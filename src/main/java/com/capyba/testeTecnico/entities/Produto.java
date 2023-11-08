package com.capyba.testeTecnico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="produto_table")
@Data 
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private boolean disponivel;
	@ManyToOne
	private Usuario comprador;
	
}
