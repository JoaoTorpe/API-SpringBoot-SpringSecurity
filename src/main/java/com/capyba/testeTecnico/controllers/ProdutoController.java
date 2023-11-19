package com.capyba.testeTecnico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(params = "disponivel")
	public ResponseEntity<List<Produto>> estaDisponivel(@RequestParam(required = false) boolean disponivel){
		
		List<Produto> produtosFiltrados = repository.findByDisponibilidade(disponivel);
		
		return ResponseEntity.ok().body(produtosFiltrados);
		
	}
	
	@GetMapping(params = "orderby")
	public ResponseEntity<List<Produto>> ordenaPor(@RequestParam(required = false) String orderby){
		List<Produto> produtosOrdenados = repository.findAll(Sort.by(orderby));
		return ResponseEntity.ok().body(produtosOrdenados);
	}
	
	@GetMapping(params = "search")
	public ResponseEntity<List<Produto>> buscar(@RequestParam(required = false) String search){
		List<Produto> produtosFiltrados = repository.findByNomeContaining(search);
		return ResponseEntity.ok().body(produtosFiltrados);
	}
	
	
	
	
}
