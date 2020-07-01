package com.mitocode.document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "matriculas")
public class Matricula {

	@Id
	private String id;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime fechamatricula;

	@DBRef
	private Estudiante estudiante;

	private List<MatriculaItem> items;
	
	@NotNull
	private boolean estado;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	
	public LocalDateTime getFechamatricula() {
		return fechamatricula;
	}

	public void setFechamatricula(LocalDateTime fechamatricula) {
		this.fechamatricula = fechamatricula;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<MatriculaItem> getItems() {
		return items;
	}

	public void setItems(List<MatriculaItem> items) {
		this.items = items;
	}


}
