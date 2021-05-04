package com.generation.EscolaGeneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.EscolaGeneration.model.Estudante;
import com.generation.EscolaGeneration.repository.EstudanteRepository;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")//CrossOrigin Libera o acesso "*" libera aceeso a qualquer IP
@RequestMapping("/estudante") //Caminho de acesso 
public class EstudanteController {
	
	@Autowired
	private EstudanteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Estudante>> getAll() {
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> getById(@PathVariable long id) {
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	private ResponseEntity<Estudante> post(@RequestBody Estudante estudante) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(estudante));
		
	}
	
	@PutMapping
	public ResponseEntity<Estudante> put(@RequestBody Estudante estudante) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(estudante));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
		
	}

}
