package com.capyba.testeTecnico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capyba.testeTecnico.DTOs.RegistroDTO;
import com.capyba.testeTecnico.entities.Usuario;
import com.capyba.testeTecnico.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class AuthController {
	
	@Autowired
	UsuarioRepository repository;
	
	@PostMapping("/registrar")
	public ResponseEntity registarUsuario(@RequestBody RegistroDTO u) {
if(repository.findByEmail(u.getEmail()) != null) return ResponseEntity.badRequest().build(); 
		
		repository.save( new Usuario(u.getEmail(),u.getNome(),u.getImagemPerfil(),u.getSenha()));
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
