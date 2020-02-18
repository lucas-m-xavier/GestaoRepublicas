package com.dev.republica.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.republica.model.Usuario;
import com.dev.republica.model.UsuarioPrincipal;
import com.dev.republica.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public ResponseEntity<Usuario> update(Long id, Usuario usuario) {
		return usuarioRepository.findById(id).map(record -> {
			record.setUsername(usuario.getUsername());
			record.setPassword(usuario.getPassword());
			record.setMorador(usuario.getMorador());
			Usuario updated = save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> deleteById(Long id) {
		return usuarioRepository.findById(id).map(record -> {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UsuarioPrincipal(usuario);
    }
}
