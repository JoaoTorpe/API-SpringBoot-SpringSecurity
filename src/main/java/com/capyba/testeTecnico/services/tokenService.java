package com.capyba.testeTecnico.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.capyba.testeTecnico.entities.Usuario;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class tokenService {
	
	private String secret = "jvts1";
	 
	public String generateToken(Usuario u) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("API")
					.withSubject(u.getEmail())
					.withExpiresAt(generateExpiration())
					.sign(algorithm);
			return token;
		}
		
		catch( JWTCreationException e ) {
			throw new RuntimeException("Erro ao gerar token",e);
		}
	}
	
	public String tokenValidation(String token) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("API")
					.build()
					.verify(token)
					.getSubject();
		}
		
		catch(JWTVerificationException e) {
			return "";
		}
		
	}
	
	
	public String  recoverToken(HttpServletRequest req) {
		
		var header = req.getHeader("Authorization");
		
		if(header == null) return null;
		
		return header.replace("Bearer ", "");
		

	}

	
	public Instant generateExpiration() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	
	
}
