package com.capyba.testeTecnico.DTOs;

import java.util.List;

import com.capyba.testeTecnico.entities.Produto;
import com.capyba.testeTecnico.entities.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {

	private long id;
	private String email;
	private String nome;
	private String imagemPerfil;
	private  List<Produto> produtosDoUsuario;
	
	
	public UsuarioDTO(Usuario u) {
		this.id = u.getId();
		this.email = u.getEmail();
		this.nome = u.getNome();
		this.imagemPerfil = u.getImagemPerfil();
		this.produtosDoUsuario = u.getProdutosDoUsuario();
	}
	
}
