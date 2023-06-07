package com.alura.controller;

import com.alura.dto.cursos.DatosActualizarCurso;
import com.alura.dto.cursos.DatosCompletosCurso;
import com.alura.dto.cursos.DatosListadoCurso;
import com.alura.dto.cursos.DatosRegistroCurso;
import com.alura.dto.usuarios.DatosActualizarUsuario;
import com.alura.dto.usuarios.DatosCompletosUsuario;
import com.alura.dto.usuarios.DatosListadoUsuario;
import com.alura.dto.usuarios.DatosRegistroUsuario;
import com.alura.modelo.Curso;
import com.alura.modelo.Usuario;
import com.alura.repository.CursoRepository;
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
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    public UsuarioRespository usuarioRepository;

    //CON PAGINACION
    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuarios(@PageableDefault(size = 2, sort = "nombre") Pageable paginacion){
        return usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosUsuario> listarUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        DatosCompletosUsuario datosCompletosUsuario= new DatosCompletosUsuario(usuario);
        return ResponseEntity.ok(datosCompletosUsuario);
    }

    @PostMapping
    public void agregar(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        Usuario usuario = new Usuario(datosRegistroUsuario);
        usuarioRepository.save(usuario);
    }

    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        System.out.println(usuario);
        usuario.actualizarDatos(datosActualizarUsuario);
    }

    //DELETE EN BASE DE DATOS
    /*
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.delete(usuario);
    }
    */

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
    }

}
