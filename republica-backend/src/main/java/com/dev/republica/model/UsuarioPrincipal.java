package com.dev.republica.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails{
	private Usuario usuario;
	
	public UsuarioPrincipal(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String getUsername() {
		return usuario.getUsername();
	}
	 
	@Override
	public String getPassword() {
		return usuario.getPassword();
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }
	
	@Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (usuario.getAtivo() == true) return true;
        
        return false;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
