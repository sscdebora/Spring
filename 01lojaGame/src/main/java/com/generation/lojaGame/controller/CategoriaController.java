package com.generation.lojaGame.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.generation.lojaGame.model.Categoria;
import com.generation.lojaGame.repository.CategoriaRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping ("/Categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long Id){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(Id).get());
	}
	@GetMapping("/console/{console}")
	public ResponseEntity<List<Categoria>> GetByConsole(@PathVariable String console){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByConsoleContainingIgnoreCase(console));		
	}
	@PostMapping("/criar")
	public ResponseEntity<Categoria>saveCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> uptadeCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		java.util.Optional<Categoria> categoriaExistente = repository.findById(id);
		
		if(categoriaExistente.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("deletada");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("não encontrada");
		}
	}

}
