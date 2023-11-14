package com.capyba.testeTecnico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capyba.testeTecnico.entities.Produto;
import com.capyba.testeTecnico.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> retornaTodos() {
		
	
		List<Produto> produtos =  repository.findAll();
		
		if(produtos.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().body(produtos);
		
	}
	
	
}
