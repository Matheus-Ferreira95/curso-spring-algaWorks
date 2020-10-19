package com.matheus.osworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.osworks.domain.model.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@GetMapping
	public List<Cliente> findAll() {
		Cliente cli1 = new Cliente(1L, "João", "joao@gmail.com", "773237372");
		Cliente cli2 = new Cliente(2L, "matheus", "matheus@gmail.com", "01001230302");
		return Arrays.asList(cli1, cli2);
	}	
}
