package com.matheus.osworks.controller.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private LocalDateTime dataEHora;
	private String mensagem;
		
	public StandardError(Integer status, LocalDateTime dataEHora, String mensagem) {
		super();
		this.status = status;
		this.dataEHora = dataEHora;
		this.mensagem = mensagem;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataEHora() {
		return dataEHora;
	}
	public void setDaaEtHora(LocalDateTime dataEHora) {
		this.dataEHora = dataEHora;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setTitulo(String mensagem) {
		this.mensagem = mensagem;
	}
}
