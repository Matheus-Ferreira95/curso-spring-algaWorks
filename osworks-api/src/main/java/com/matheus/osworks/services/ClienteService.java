package com.matheus.osworks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.osworks.domain.model.Cliente;
import com.matheus.osworks.domain.repository.ClienteRepository;
import com.matheus.osworks.services.exceptions.DoMainException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente insert(Cliente cliente) {
		Cliente entity = clienteRepository.findByEmail(cliente.getEmail());
		
		if (entity != null && !entity.equals(cliente)) {
			throw new DoMainException("Já existe um cliente cadastrado com este e-mail");
		}
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
		
	public void delete(Long id) {		
		clienteRepository.deleteById(id);		
	}	
	
}
