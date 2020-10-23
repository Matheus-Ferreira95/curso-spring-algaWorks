package com.matheus.osworks.domain.model.dto;

import javax.validation.constraints.NotBlank;

public class InsertComentarioDTO {
	
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
