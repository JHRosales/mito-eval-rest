package com.mitocode.document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cursos")
public class Curso {

	@Id
	private String id;

	@Field(name = "nombre") // @Column | similar
	@NotEmpty
	@Size(min = 3)
	private String nombre;

	@Field(name = "siglas")
	@NotEmpty
	@Size(min = 2)
	private String siglas;

	@NotNull
	private boolean estado;

	public Curso() {

	}
	
	public Curso(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
