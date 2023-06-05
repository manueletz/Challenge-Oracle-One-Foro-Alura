package com.alura.modelo;

import java.time.LocalDateTime;

public record DatosRegistroTopico(String titulo, String mensaje, Curso curso, Usuario autor) {
}
