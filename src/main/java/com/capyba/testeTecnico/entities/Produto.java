package com.capyba.testeTecnico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="produto_table")
@Getter
@Setter
@NoArgsConstructor
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private Double preco;
	private boolean disponivel;
	
	@ManyToMany(mappedBy = "produtosDoUsuario")
	private List<Usuario> compradores;
	
	public Produto(String nome, boolean disponivel,Double preco) {
		this.nome = nome;
		this.preco = preco;
		this.disponivel = disponivel;
		this.compradores = new ArrayList<Usuario>();
		}

	
	
	
}
