package com.alura.dto.cursos;

import com.alura.modelo.Curso;
import com.alura.modelo.Topico;

import java.time.LocalDateTime;

public record DatosListadoCurso(Long id, String nombre, String categoria) {

    public DatosListadoCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
