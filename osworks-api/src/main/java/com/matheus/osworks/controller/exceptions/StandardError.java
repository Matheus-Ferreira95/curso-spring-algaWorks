package com.matheus.osworks.controller.exceptions;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private OffsetDateTime dataEHora;
	private String mensagem;
	private String path;
		
	public StandardError(Integer status, OffsetDateTime dataEHora, String mensagem, String path) {
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
	public OffsetDateTime getDataEHora() {
		return dataEHora;
	}
	public void setDaaEtHora(OffsetDateTime dataEHora) {
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