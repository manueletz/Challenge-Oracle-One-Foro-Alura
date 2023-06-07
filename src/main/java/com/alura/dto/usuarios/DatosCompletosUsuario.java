package com.alura.dto.usuarios;

import com.alura.modelo.Curso;
import com.alura.modelo.Usuario;

public record DatosCompletosUsuario(Long id, String nombre, String email, String contrasena, Boolean activo) {

    public DatosCompletosUsuario(Usuario usuario){

        this(usuario.getId(), usuario.getNombre(),
                usuario.getEmail(), usuario.getContrasena(), usuario.getActivo());
    }
}

