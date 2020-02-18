package com.dev.republica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.republica.model.Usuario;
import com.dev.republica.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@GetMapping(path = { "/{id}" })
	public Usuario getUsuarioById(@PathVariable Long id) {
		return usuarioService.getUsuario(id);
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return usuario;
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		return usuarioService.update(id, usuario);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return usuarioService.deleteById(id);
	}
}
