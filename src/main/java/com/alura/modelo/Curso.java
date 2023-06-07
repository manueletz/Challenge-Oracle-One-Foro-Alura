package com.alura.modelo;

import com.alura.dto.cursos.DatosActualizarCurso;
import com.alura.dto.cursos.DatosRegistroCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	private String categoria;

	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Topico> topicos = new ArrayList<>();

    public Curso(DatosRegistroCurso datosRegistroCurso) {
		this.nombre = datosRegistroCurso.nombre();
		this.categoria = datosRegistroCurso.categoria();
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
		Curso other = (Curso) obj;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
		if (datosActualizarCurso.nombre() !=null) {
			this.nombre = datosActualizarCurso.nombre();
		}
		if (datosActualizarCurso.categoria() !=null) {
			this.categoria = datosActualizarCurso.categoria();
		}
	}
}
