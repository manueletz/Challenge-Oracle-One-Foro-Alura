package com.alura.controller;

import com.alura.dto.topico.*;
import com.alura.modelo.*;
import com.alura.repository.CursoRepository;
import com.alura.repository.TopicoRepository;
import com.alura.repository.UsuarioRespository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    @Autowired
    public TopicoRepository topicoRepository;

    @Autowired
    public CursoRepository cursoRepository;

    @Autowired
    public UsuarioRespository usuarioRespository;

//    @GetMapping
//    public List<Topico> leer(){
//        return topicoRepository.findAll();
//    }

    //SIN PAGINACION
//    @GetMapping
//    public List<DatosListadoTopico> listadoTopicos(){
//        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
//    }

    //CON PAGINACION
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>>  listadoTopicos(@PageableDefault(size = 5, sort = "titulo") Pageable paginacion){
        //return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(topicoRepository.findAllByAutorActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosTopico> listarTopicoPorId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        DatosCompletosTopico datosCompletosTopico= new DatosCompletosTopico(topico);
        return ResponseEntity.ok(datosCompletosTopico);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> agregar(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                  UriComponentsBuilder uriComponentsBuilder){
        Long id_curso = datosRegistroTopico.id_curso();
        Long id_usuario = datosRegistroTopico.id_usuario();

        Curso curso = cursoRepository.findAllById(id_curso);
        Usuario usuario = usuarioRespository.findAllById(id_usuario);

        Topico topico = new Topico(datosRegistroTopico, curso, usuario);
        topicoRepository.save(topico);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getfechaCreacion(), topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre());

        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        //(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, String autor , String curso) {
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(), topico.getfechaCreacion(),
                topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

}
