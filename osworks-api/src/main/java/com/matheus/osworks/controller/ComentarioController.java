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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.osworks.domain.model.Comentario;
import com.matheus.osworks.domain.model.OrdemServico;
import com.matheus.osworks.domain.model.dto.ComentarioDTO;
import com.matheus.osworks.domain.model.dto.InsertComentarioDTO;
import com.matheus.osworks.services.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<ComentarioDTO> insert(@PathVariable Long ordemServicoId,@Valid @RequestBody InsertComentarioDTO insertDTO) {
		Comentario comentario = ordemServicoService.addComment(ordemServicoId, insertDTO.getDescricao());	
		ComentarioDTO dto = toDTO(comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comentario.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ComentarioDTO>> findAll(@PathVariable Long ordemServicoId) {
		OrdemServico ordemServico = ordemServicoService.findById(ordemServicoId);
		List<ComentarioDTO> listDTO = toDTOList(ordemServico.getComentarios());
		return ResponseEntity.ok().body(listDTO);
	}
	
	private List<ComentarioDTO> toDTOList(List<Comentario> comentarios) {
		return comentarios.stream().map(comentario -> toDTO(comentario))
				.collect(Collectors.toList());
	}

	private ComentarioDTO toDTO(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioDTO.class);
	}	
}
