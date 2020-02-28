package com.dev.republica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.republica.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	Privilege findByName(String name);
}
