package com.matheus.osworks.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.osworks.domain.model.Cliente;
import com.matheus.osworks.domain.model.OrdemServico;
import com.matheus.osworks.domain.model.enums.StatusOrdemServico;
import com.matheus.osworks.domain.repository.ClienteRepository;
import com.matheus.osworks.domain.repository.OrdemServicoRepository;
import com.matheus.osworks.services.exceptions.DoMainException;
import com.matheus.osworks.services.exceptions.ResourceNotFoundException;

@Service
public class OrdemServicoService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrdemServicoRepository repository;
	
	public OrdemServico insert(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new DoMainException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA); // tanto o status quanto a data de abertura, o ideal é fazer assim mesmo
		ordemServico.setDataAbertura(LocalDateTime.now()); // pois é o nosso sistema que tem que processar esses campos		
		return repository.save(ordemServico);
	}	
	
	public List<OrdemServico> findAll(){
		return repository.findAll();
	}
	
	public OrdemServico findById(Long id) {
		Optional<OrdemServico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("OrdemServico não existente"));
	}
	
}
