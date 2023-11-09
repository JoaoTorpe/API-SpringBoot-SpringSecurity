package com.capyba.testeTecnico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capyba.testeTecnico.entities.Usuario;
import com.capyba.testeTecnico.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repository;
	
	public void registrarUsuario(Usuario u) {
		repository.save(u);
	}

}
