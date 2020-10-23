package com.matheus.osworks.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InsertOrdemServicoDTO implements Serializable {	
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;	
	
	@NotNull
	private Long clienteId;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Long getClienteId() {
		return clienteId;
	}
	
	public void setCliente(Long clienteId) {
		this.clienteId = clienteId;
	}
}
