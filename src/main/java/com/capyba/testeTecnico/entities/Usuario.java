package com.capyba.testeTecnico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="user_table")
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable , UserDetails {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String nome;
	private String imagemPerfil;
	private String senha;
	@ManyToMany
	@JoinTable(name = "Compra",
			joinColumns = @JoinColumn(name = "usuario_id"),
		    inverseJoinColumns = @JoinColumn(name = "produto_id"))
	@JsonIgnore
	private  List<Produto> produtosDoUsuario;
	
	
	public Usuario(String email,String nome,String imagemPerfil,String senha) {
		
		this.email =  email;
		this.nome = nome;
		this.imagemPerfil = imagemPerfil;
		this.senha = senha;
		this.produtosDoUsuario = new ArrayList<Produto>();
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
