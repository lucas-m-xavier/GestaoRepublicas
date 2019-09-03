package com.dev.republica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.republica.model.Republica;

@Repository
public interface RepublicaRepository extends JpaRepository<Republica, Long> {

	List<Republica> findByNumeroVagasDisponiveisGreaterThanEqual(byte numeroVagasDisponiveis);

}