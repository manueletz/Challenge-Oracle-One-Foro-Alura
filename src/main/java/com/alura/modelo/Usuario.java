package com.alura.modelo;

import com.alura.dto.usuarios.DatosActualizarUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	private String email;
	private String contrasena;

	@OneToMany(mappedBy = "autor")
	//@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Topico> topicos = new ArrayList<>();

    public Usuario(Long id){
		this.id = id;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
		if (datosActualizarUsuario.nombre() !=null) {
			this.nombre = datosActualizarUsuario.nombre();
		}
		if (datosActualizarUsuario.email() !=null) {
			this.email = datosActualizarUsuario.email();
		}
		if (datosActualizarUsuario.contrasena() !=null) {
			this.contrasena = datosActualizarUsuario.contrasena();
		}
    }
}
