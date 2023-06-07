package com.alura.dto.topico;

import com.alura.modelo.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, String autor , String curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(), topico.getfechaCreacion(),
                topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }

}
