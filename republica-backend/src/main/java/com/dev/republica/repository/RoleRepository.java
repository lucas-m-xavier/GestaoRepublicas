package com.dev.republica.repository;

import com.dev.republica.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name);
}
