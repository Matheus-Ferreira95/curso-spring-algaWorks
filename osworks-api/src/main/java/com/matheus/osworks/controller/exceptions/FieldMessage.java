package com.matheus.osworks.controller.exceptions;

public class FieldMessage {
	
	private String nome;
	private String mensagem;
		
	public FieldMessage(String nome, String mensagem) {
		this.nome = nome;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}