package com.alura.controller;

import com.alura.dto.cursos.DatosActualizarCurso;
import com.alura.dto.cursos.DatosCompletosCurso;
import com.alura.dto.cursos.DatosListadoCurso;
import com.alura.dto.cursos.DatosRegistroCurso;
import com.alura.modelo.*;
import com.alura.repository.CursoRepository;
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
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    @Autowired
    public CursoRepository cursoRepository;

    //CON PAGINACION
    @GetMapping
    public Page<DatosListadoCurso> listadoCursos(@PageableDefault(size = 2, sort = "nombre") Pageable paginacion){
        return cursoRepository.findAll(paginacion).map(DatosListadoCurso::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosCompletosCurso> listarCursoPorId(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        DatosCompletosCurso datosCompletosCurso= new DatosCompletosCurso(curso);
        return ResponseEntity.ok(datosCompletosCurso);
    }

    @PostMapping
    public void agregar(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso){
        Curso curso = new Curso(datosRegistroCurso);
        cursoRepository.save(curso);
    }

    @PutMapping
    @Transactional
    public void actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
    }

}
