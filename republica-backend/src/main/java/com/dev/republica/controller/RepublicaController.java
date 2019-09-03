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

import com.dev.republica.model.Republica;
import com.dev.republica.service.RepublicaService;

@RestController
@RequestMapping("/republicas")
@CrossOrigin(origins = "http://localhost:4200")
public class RepublicaController {

	private RepublicaService republicaService;

	public RepublicaController(RepublicaService republicaService) {
		this.republicaService = republicaService;
	}

	@GetMapping
	public List<Republica> getRepublicas() {
		return republicaService.getAllRepublicas();
	}

	@GetMapping(path = { "/{id}" })
	public Republica getRepublicaById(@PathVariable Long id) {
		return republicaService.getRepublica(id);
	}

	@PostMapping
	public Republica create(@RequestBody Republica republica) {
		return republicaService.save(republica);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Republica> update(@PathVariable("id") Long id, @RequestBody Republica republica) {
		return republicaService.update(id, republica);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return republicaService.deleteById(id);
	}

	@GetMapping(path = { "/disponiveis" })
	public List<Republica> getRepublicasDisponiveis() {
		return republicaService.getRepublicasDisponiveis();
	}
}
