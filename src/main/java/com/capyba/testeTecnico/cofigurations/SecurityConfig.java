package com.capyba.testeTecnico.cofigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.capyba.testeTecnico.services.SecurityFilter;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	SecurityFilter filter;
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
		 
		  
		 
	        return  httpSecurity
	                .csrf(csrf -> csrf.disable())
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authorizeHttpRequests(authorize -> authorize
	                		 .requestMatchers(PathRequest.toH2Console()).permitAll()
	                		 .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()	
	                		.requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
	                		.requestMatchers(HttpMethod.POST,"/auth/registrar").permitAll()
	                		.requestMatchers(HttpMethod.GET,"auth/policy").permitAll()
	                		.requestMatchers(HttpMethod.POST,"auth/logout").authenticated()
	                		.anyRequest().authenticated()
	                )
	                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }
	 
	 
	 @Bean
	 public AuthenticationManager autheticaAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 return authenticationConfiguration.getAuthenticationManager();
		 
	 }
	
	              
	 
	 private SecurityScheme createAPIKeyScheme() {
		    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
		        .bearerFormat("JWT")
		        .scheme("bearer");
		}
	 
	 
	 @Bean
	 public OpenAPI openAPI() {
	     return new OpenAPI().addSecurityItem(new SecurityRequirement().
	             addList("Bearer Authentication"))
	         .components(new Components().addSecuritySchemes
	             ("Bearer Authentication", createAPIKeyScheme()))
	         .info(new Info().title("My REST API")
	             .description("Some custom description of API.")
	             .version("1.0").contact(new Contact().name("Sallo Szrajbman")
	                 .email( "www.baeldung.com").url("salloszraj@gmail.com"))
	             .license(new License().name("License of API")
	                 .url("API license URL")));
	 }
	 
	 
	 
	 @Bean
	 public PasswordEncoder passWordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 
	
	
}
