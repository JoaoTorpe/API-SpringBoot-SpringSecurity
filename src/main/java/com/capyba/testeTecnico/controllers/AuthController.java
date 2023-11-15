package com.capyba.testeTecnico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capyba.testeTecnico.DTOs.LoginDTO;
import com.capyba.testeTecnico.DTOs.RegistroDTO;
import com.capyba.testeTecnico.entities.Usuario;
import com.capyba.testeTecnico.repositories.UsuarioRepository;
import com.capyba.testeTecnico.services.RevokService;
import com.capyba.testeTecnico.services.tokenService;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private tokenService tokenServ;
	@Autowired
	private RevokService revok;
	
	@PostMapping("/login")
	
	public ResponseEntity login(@RequestBody LoginDTO data) {
		var usuarioSenha = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
		var auth = authenticationManager.authenticate(usuarioSenha);
		var token = tokenServ.generateToken((Usuario)auth.getPrincipal());
		
		return ResponseEntity.ok(token);
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity registarUsuario(@RequestBody RegistroDTO u) {
if(repository.findByEmail(u.getEmail()) != null) return ResponseEntity.badRequest().build(); 
		
String senhaEncrypitada = new BCryptPasswordEncoder().encode(u.getSenha());
		repository.save( new Usuario(u.getEmail(),u.getNome(),u.getImagemPerfil(),senhaEncrypitada));
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/logout")
	public ResponseEntity logout(HttpServletRequest req) {
		String token = tokenServ.recoverToken(req);
		revok.addToBlackList(token);
		return ResponseEntity.ok().build();
	}
	
	
}
