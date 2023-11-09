package com.capyba.testeTecnico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capyba.testeTecnico.entities.Usuario;
import com.capyba.testeTecnico.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@PostMapping
	public void registarUsuario(@RequestBody Usuario u) {
		service.registrarUsuario(u);
	}
	
}
