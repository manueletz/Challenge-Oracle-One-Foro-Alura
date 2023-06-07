package com.alura.dto.cursos;

import com.alura.modelo.Curso;
import com.alura.modelo.Topico;

import java.time.LocalDateTime;

public record DatosCompletosCurso(Long id, String nombre, String categoria) {

    public DatosCompletosCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}

