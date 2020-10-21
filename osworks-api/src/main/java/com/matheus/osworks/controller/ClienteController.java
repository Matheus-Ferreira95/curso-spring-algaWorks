package com.matheus.osworks.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.osworks.domain.model.Cliente;
import com.matheus.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = clienteRepository.findAll();
		return ResponseEntity.ok().body(list);
		//return clienteRepository.findByNome("João da Silva");
		//return clienteRepository.findByNomeContaining("a");
	}
	
	@GetMapping(value = "/{clienteId}")
	public ResponseEntity<Cliente> findById(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok().body(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cliente) {
		Cliente cli = clienteRepository.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).body(cli);
	}
	
	@PutMapping(value = "/{clienteId}")
	public ResponseEntity<Cliente> update(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
		
		if (clienteRepository.existsById(clienteId)) {		
			Cliente entity = clienteRepository.getOne(clienteId);
			entity.setNome(cliente.getNome());
			entity.setEmail(cliente.getEmail());
			entity.setTelefone(cliente.getTelefone());
			entity = clienteRepository.save(entity);
			return ResponseEntity.ok().body(entity);
		}
		
		return ResponseEntity.notFound().build();
	}	
	
	@DeleteMapping(value = "/{clienteId}")
	public ResponseEntity<Void> delete(@PathVariable Long clienteId) {
		
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
}
