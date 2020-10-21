package com.matheus.osworks.controller.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private LocalDateTime datHora;
	private String titulo;
		
	public StandardError(Integer status, LocalDateTime datHora, String titulo) {
		super();
		this.status = status;
		this.datHora = datHora;
		this.titulo = titulo;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDatHora() {
		return datHora;
	}
	public void setDatHora(LocalDateTime datHora) {
		this.datHora = datHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
