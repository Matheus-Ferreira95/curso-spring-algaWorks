package com.matheus.osworks.controller.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private LocalDateTime dataEHora;
	private String mensagem;
	private String path;
		
	public StandardError(Integer status, LocalDateTime dataEHora, String mensagem, String path) {
		super();
		this.status = status;
		this.dataEHora = dataEHora;
		this.mensagem = mensagem;
		this.setPath(path);
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
