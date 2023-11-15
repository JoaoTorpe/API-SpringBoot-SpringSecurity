package com.capyba.testeTecnico.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.capyba.testeTecnico.repositories.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{
		@Autowired
		 tokenService tokenServ;
		@Autowired
		UsuarioRepository usuarioRepository;
		@Autowired
		RevokService revok;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException 
	{
		  var token = tokenServ.recoverToken(request);
	        if(token != null && !revok.isInBlackList(token)){
	            var login = tokenServ.tokenValidation(token);
	            UserDetails user = usuarioRepository.findByEmail(login);

	            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }
	        filterChain.doFilter(request, response);
		
	}
	


}
