package com.FarmaciaGeneration.FarmaciaGene.controller;

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

import com.FarmaciaGeneration.FarmaciaGene.model.Classe;
import com.FarmaciaGeneration.FarmaciaGene.repository.ClasseRepository;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")//CrossOrigin Libera o acesso "*" libera aceeso a qualquer IP
@RequestMapping("/classe")
public class ClasseController {
	
	@Autowired
	private ClasseRepository repository;
	
	public ResponseEntity<List<Classe>> getAll() {
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Classe> getById(@PathVariable long id) {
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<Classe> post(@RequestBody Classe classe) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(classe));
		
	}
	
	@PutMapping
	public ResponseEntity<Classe> put(@RequestBody Classe classe) {
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(classe));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
		
	}
	

}
