package com.capyba.testeTecnico.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capyba.testeTecnico.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p WHERE p.disponivel = :disponivel")
    List<Produto> findByDisponibilidade(@Param("disponivel") boolean disponivel);
	
    List<Produto> findAll(Sort sort);
    
    List<Produto> findByNomeContaining(String nome);
}
