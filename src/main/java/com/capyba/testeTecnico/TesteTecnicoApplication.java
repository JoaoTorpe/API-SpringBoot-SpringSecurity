package com.capyba.testeTecnico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capyba.testeTecnico.entities.Produto;
import com.capyba.testeTecnico.entities.Usuario;
import com.capyba.testeTecnico.repositories.ProdutoRepository;
import com.capyba.testeTecnico.repositories.UsuarioRepository;

@SpringBootApplication
public class TesteTecnicoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesteTecnicoApplication.class, args);
	}

	@Autowired
	UsuarioRepository userRepo;
	@Autowired
	ProdutoRepository prodRepo;
	@Override
	public void run(String... args) throws Exception {
		
		 Usuario u1 = new Usuario("joao@email.com", "joao", "urlImg", "123456");
		    userRepo.save(u1); 
		    Usuario u2 = new Usuario("joao@email.com", "pedro", "urlImg", "123456");
		    userRepo.save(u2); 

		    Produto p1 = new Produto("mouse", true, 120.00);
		    prodRepo.save(p1); 
		    
		    Produto p2 = new Produto("teclado", true, 510.00);
		    prodRepo.save(p2);
		    
		  p1.getCompradores().add(u1);
		  p1.getCompradores().add(u2);
		  u1.getProdutosDoUsuario().add(p1);
		  u2.getProdutosDoUsuario().add(p1);
		  
		  u1.getProdutosDoUsuario().add(p2);
		  p2.getCompradores().add(u1);
		    
		  userRepo.save(u2); 
		  userRepo.save(u1); 
		  prodRepo.save(p1); 
		  prodRepo.save(p2);
		
		
		
	}

}
