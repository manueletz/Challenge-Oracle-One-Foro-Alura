package com.alura.dto.usuarios;

import com.alura.modelo.Curso;
import com.alura.modelo.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email, String contrasena) {

    public DatosListadoUsuario(Usuario usuario){

        this(usuario.getId(), usuario.getNombre(),
                usuario.getEmail(), usuario.getContrasena());
    }
}
