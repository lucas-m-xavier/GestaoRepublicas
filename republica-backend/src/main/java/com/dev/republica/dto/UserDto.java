package com.dev.republica.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dev.republica.model.Morador;
import com.dev.republica.validation.PasswordMatches;
import com.dev.republica.validation.ValidPassword;
import com.dev.republica.validation.ValidUsername;

@PasswordMatches
public class UserDto {
	
	@ValidUsername
	@NotNull
	@Size(min = 1, message = "{Size.userDto.username}")
	private String username;
	
	@ValidPassword
	private String password;
	
	@NotNull
	private String matchingPassword;
	
	private Morador morador;
	
	private Integer role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", role=" + role + "]";
	}

}
