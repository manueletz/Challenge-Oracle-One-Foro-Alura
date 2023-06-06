package com.alura.modelo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Table(name = "topicos")
@Entity(name = "Topico")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull
	private String titulo;
	@NotNull
	private String mensaje;
	@NotNull
	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
    private Usuario autor;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso")
    private Curso curso;

	@Transient
    private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	/*
	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.curso = datosRegistroTopico.curso();
		this.autor = datosRegistroTopico.usuario();
		//this.status = StatusTopico.NO_RESPONDIDO;
	}
	*/

	public Topico(){
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
		Topico other = (Topico) obj;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if (datosActualizarTopico.titulo() !=null) {
			this.titulo = datosActualizarTopico.titulo();
		}
		if (datosActualizarTopico.mensaje() !=null) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if (datosActualizarTopico.id_curso() !=null) {
			this.curso.setId(datosActualizarTopico.id_curso());
		}
		if (datosActualizarTopico.id_usuario() !=null) {
			this.autor.setId(datosActualizarTopico.id_usuario());
		}
	}

}
