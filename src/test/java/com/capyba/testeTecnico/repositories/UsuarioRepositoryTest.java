package com.capyba.testeTecnico.repositories;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.capyba.testeTecnico.entities.Usuario;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;

	@Autowired
	EntityManager entityManeger;
	
	@Test
	void findByEmail() {
		Usuario novoUsuario = new Usuario("teste@email","teste", "urlRandon", "password");
		
		persistirUsuario(novoUsuario);
		
		Usuario resultado = (Usuario) repository.findByEmail(novoUsuario.getEmail());
		
		assertEquals(novoUsuario,resultado);
		
	}
	
	
	private void  persistirUsuario(Usuario novoUsuario) {
		
		this.entityManeger.persist(novoUsuario);
	}
	
	
}
