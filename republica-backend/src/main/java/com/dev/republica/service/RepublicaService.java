package com.dev.republica.service;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;

@Validated
public interface RepublicaService {

	List<Republica> getAllRepublicas();

	Republica getRepublica(@Min(value = 1L, message = "ID Republica inválido.") Long id);

	Republica save(Republica republica);

	ResponseEntity<Republica> update(Long id, Republica republica);

	ResponseEntity<?> deleteById(Long id);

	List<Republica> getRepublicasDisponiveis();

	Republica addMorador(Republica republica, Morador morador);
}
