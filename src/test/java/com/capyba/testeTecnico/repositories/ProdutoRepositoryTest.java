package com.capyba.testeTecnico.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.capyba.testeTecnico.entities.Produto;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class ProdutoRepositoryTest {
	
	@Autowired
	ProdutoRepository Repository;
	
	@Autowired
	EntityManager entityManeger;
	@Test
	void findByDisponibilidade() {
		generateProdutos();
		List<Produto> produtosDisponiveis = Repository.findByDisponibilidade(true);
		List<Produto> produtosNaoDisponiveis = Repository.findByDisponibilidade(false);
		
		assertThat(produtosDisponiveis).isNotEmpty();
		assertThat(produtosNaoDisponiveis).isNotEmpty();
		
		 assertThat(produtosDisponiveis).allMatch(produto -> produto.isDisponivel());
		 assertThat(produtosNaoDisponiveis).allMatch(produto -> !produto.isDisponivel());
	}
	
	private void generateProdutos() {
		Produto produto1 = new Produto("Produto A", true, 29.99);
		Produto produto2 = new Produto("Produto B", false, 39.99);
		Produto produto3 = new Produto("Produto C", true, 89.99);
		Produto produto4 = new Produto("Produto D", false, 159.99);
	      
		
		this.entityManeger.persist(produto1);
		this.entityManeger.persist(produto2);
		this.entityManeger.persist(produto3);
		this.entityManeger.persist(produto4);
	}

}
