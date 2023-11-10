package com.capyba.testeTecnico.DTOs;

import com.capyba.testeTecnico.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RegistroDTO {

	private String email;
	private String nome;
	private String imagemPerfil;
	private String senha;
	
	
	public RegistroDTO(Usuario u) {
		this.email = u.getEmail();
		this.nome = u.getNome();
		this.imagemPerfil = u.getImagemPerfil();
		this.senha = u.getSenha();
	}
	
}
