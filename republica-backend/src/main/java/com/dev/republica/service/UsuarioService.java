package com.dev.republica.service;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

import com.dev.republica.model.Usuario;

@Validated
public interface UsuarioService extends UserDetailsService{
	
	List<Usuario> getAllUsuarios();
	
	Usuario getUsuario(@Min(value = 1L, message = "ID Usuario inválido.") Long id);
	
	Usuario save(Usuario usuario);
	
	ResponseEntity<Usuario> update(Long id, Usuario usuario);
	
	ResponseEntity<?> deleteById(Long id);
}
