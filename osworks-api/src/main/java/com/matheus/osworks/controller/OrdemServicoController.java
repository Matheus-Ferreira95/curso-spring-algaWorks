package com.matheus.osworks.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.osworks.domain.model.OrdemServico;
import com.matheus.osworks.services.OrdemServicoService;

@RestController
@RequestMapping(value="/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService service;	
	
	@PostMapping
	public ResponseEntity<OrdemServico> insert(@Valid @RequestBody OrdemServico ordemServico){
		ordemServico = service.insert(ordemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).body(ordemServico);
	}
	
	@GetMapping
	public ResponseEntity<List<OrdemServico>> findAll() {
		List<OrdemServico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
		OrdemServico orderServico = service.findById(id);
		return ResponseEntity.ok().body(orderServico);
	}
	
}
