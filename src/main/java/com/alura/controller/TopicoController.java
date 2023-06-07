package com.alura.controller;

import com.alura.dto.topico.DatosActualizarTopico;
import com.alura.dto.topico.DatosCompletosTopico;
import com.alura.dto.topico.DatosListadoTopico;
import com.alura.dto.topico.DatosRegistroTopico;
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
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 5, sort = "titulo") Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosTopico> listarTopicoPorId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        DatosCompletosTopico datosCompletosTopico= new DatosCompletosTopico(topico);
        return ResponseEntity.ok(datosCompletosTopico);
    }

    @PostMapping
    public void agregar(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        Long id_curso = datosRegistroTopico.id_curso();
        Long id_usuario = datosRegistroTopico.id_usuario();


        Curso curso = cursoRepository.findAllById(id_curso);

        Usuario usuario = usuarioRespository.findAllById(id_usuario);

        Topico topico = new Topico();

        topico.setTitulo(datosRegistroTopico.titulo());
        topico.setMensaje(datosRegistroTopico.mensaje());
        topico.setCurso(curso);
        topico.setAutor(usuario);

        System.out.println(topico);

        topicoRepository.save(topico);
        System.out.println("fin de agregar en Topico Controller");

    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        System.out.println(topico);
        topico.actualizarDatos(datosActualizarTopico);
        /*
        Long id_curso = datosActualizarTopico.id_curso();
        Long id_usuario = datosActualizarTopico.id_usuario();

        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setMensaje(datosActualizarTopico.mensaje());
        topico.getCurso().setId(id_curso);
        topico.getAutor().setId(id_usuario);

         */
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

}
