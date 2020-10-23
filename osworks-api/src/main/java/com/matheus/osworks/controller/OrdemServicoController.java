package com.matheus.osworks.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.osworks.domain.model.OrdemServico;
import com.matheus.osworks.domain.model.dto.InsertOrdemServicoDTO;
import com.matheus.osworks.domain.model.dto.OrdemServicoDTO;
import com.matheus.osworks.services.OrdemServicoService;

@RestController
@RequestMapping(value="/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService service;	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<OrdemServicoDTO> insert(@Valid @RequestBody InsertOrdemServicoDTO insertDto) {
		OrdemServico ordemServico = toEntity(insertDto);
		ordemServico = service.insert(ordemServico);
		OrdemServicoDTO dto = toDTO(ordemServico);		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServicoDTO>> findAll() {
		List<OrdemServico> list = service.findAll();
		List<OrdemServicoDTO> listDTO = toDTOList(list);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemServicoDTO> findById(@PathVariable Long id) {
		OrdemServico ordemServico = service.findById(id);
		OrdemServicoDTO dto = toDTO(ordemServico);
		return ResponseEntity.ok().body(dto);
	}	
	
	@PutMapping(value = "/{ordemServicoId}/finalizacao")
	public ResponseEntity<Void> finishOrderService(@PathVariable Long ordemServicoId) {
		service.finishOrdemService(ordemServicoId);
		return ResponseEntity.noContent().build();
	}
	
	private OrdemServico toEntity(InsertOrdemServicoDTO dto) {
		return modelMapper.map(dto, OrdemServico.class);
	}
	
	private OrdemServicoDTO toDTO(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoDTO.class);	
	}
	
	private List<OrdemServicoDTO> toDTOList(List<OrdemServico> ordensServico) {
		return ordensServico.stream()
				.map(ordemServico -> toDTO(ordemServico))
				.collect(Collectors.toList());
	}
}
