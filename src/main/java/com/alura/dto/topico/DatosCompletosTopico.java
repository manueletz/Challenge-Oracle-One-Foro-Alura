package com.alura.dto.topico;

import com.alura.modelo.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCompletosTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, String autor , String curso) {

    public DatosCompletosTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(), topico.getfechaCreacion(), topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}

