package com.dev.republica.service;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;

@Validated
public interface MoradorService {

	Morador getMorador(@Min(value = 1L, message = "ID Morador inválido.") Long id);

	Morador save(Morador morador);

	Morador update(Long id, Morador morador);

	ResponseEntity<?> deleteById(Long id);

	List<Morador> getAllMoradores();

	List<Morador> getMoradoresByRepublica(Republica republica);

}
