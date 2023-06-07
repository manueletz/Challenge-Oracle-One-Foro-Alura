package com.alura.dto.usuarios;

import com.alura.modelo.Curso;
import com.alura.modelo.Usuario;

public record DatosCompletosUsuario(Long id, String nombre, String email, String contrasena) {

    public DatosCompletosUsuario(Usuario usuario){

        this(usuario.getId(), usuario.getNombre(),
                usuario.getEmail(), usuario.getContrasena());
    }
}

