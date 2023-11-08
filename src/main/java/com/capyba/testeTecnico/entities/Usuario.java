package com.capyba.testeTecnico.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="user_table")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String nome;
	private String imagemPerfil;
	@OneToMany(mappedBy = "comprador")
	private  List<Produto> produtosDoUsuario;
	
	public Usuario(String email,String nome,String imagemPerfil) {
		
		this.email =  email;
		this.nome = nome;
		this.imagemPerfil = imagemPerfil;
		
	}
}
