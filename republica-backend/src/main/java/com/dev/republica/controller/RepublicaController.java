package com.dev.republica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;
import com.dev.republica.service.MoradorService;
import com.dev.republica.service.RepublicaService;

@RestController
@RequestMapping("/republicas")
@CrossOrigin
public class RepublicaController {

	@Autowired
	private RepublicaService republicaService;
	@Autowired
	private MoradorService moradorService;

	public RepublicaController(RepublicaService republicaService, MoradorService moradorService) {
		this.republicaService = republicaService;
		this.moradorService = moradorService;
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
		Morador morador = republica.getRepresentante();
		republicaService.save(republica);
		morador.setRepresentante(true);
		morador.setRepublica(republica);
		moradorService.save(morador);
		return republica;
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

	@GetMapping(path = { "/{id}/moradores" })
	public List<Morador> getRepublicaMoradores(@PathVariable Long id) {
		return republicaService.getRepublica(id).getMoradores();
	}

	@GetMapping(path = { "/{id}/adicionarmorador/{idMorador}" })
	public boolean addMorador(@PathVariable Long id, @PathVariable Long idMorador) {
		Republica republica = republicaService.getRepublica(id);
		Morador morador = moradorService.getMorador(idMorador);
		if (republica != null) {
			morador.setRepublica(republica);
			moradorService.save(morador);
			return true;
		}
		return false;
	}

	@PostMapping(path = { "/{id}/adicionarmorador" })
	public boolean addMorador2(@PathVariable Long id, @RequestBody Morador m) {

		Morador morador = moradorService.getMorador(m.getId());

		// Remove morador da republica atual
		morador.getRepublica().remove(morador);
		republicaService.save(morador.getRepublica());
		morador.setRepublica(null);

		Republica republica = republicaService.getRepublica(id);

		// Verifica se a republica existe
		if (republica != null) {
			// Verifica se o morador já está na repúblicae
			if (morador.getRepublica() == null) {
				// Verifica se existem vagas
				if (republica.getNumeroVagasDisponiveis() > 0) {
					morador.setRepublica(republica);
					republica.addMorador(morador);
					republicaService.save(republica);
					moradorService.save(morador);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@GetMapping(path = { "/{idRepublica}/removermorador/{idMorador}" })
	public boolean deleteMorador(@PathVariable Long idRepublica, @PathVariable Long idMorador) {
		Morador morador = moradorService.getMorador(idMorador);
		if (morador.getRepublica().getId() == idRepublica && morador != null) {
			Republica r = republicaService.getRepublica(morador.getRepublica().getId());
			// verificar se é representante ou se só possui ele na republica
			if (!(r.getNumeroVagas() - r.getNumeroVagasDisponiveis() == 1)) {
				if (r.getRepresentante().equals(morador)) {
					r.setRepresentante(r.getMoradores().get(0));
					r.getRepresentante().setRepresentante(true);
				}
				morador.setRepublica(null);
				republicaService.save(r);
				moradorService.save(morador);
				// return "Morador removido com sucesso";
				return true;
			} else {
				// return "A República só possui um morador! Apague a república para completar a
				// ação.";
			}
		}
		return false;
		// return "Morador não pertence a república";
	}

	@GetMapping(path = { "/{idRepublica}/alterarrepresentante/{idNovoRepresentante}" })
	public boolean alterarRepresentante(@PathVariable Long idRepublica, @PathVariable Long idNovoRepresentante) {
		Morador novoRepresentante = moradorService.getMorador(idNovoRepresentante);
		Republica republica = republicaService.getRepublica(idRepublica);
		if (novoRepresentante.getRepublica().equals(republica)) {
			Morador exRepresentante = republica.getRepresentante();
			exRepresentante.setRepresentante(false);
			republica.setRepresentante(novoRepresentante);
			novoRepresentante.setRepresentante(true);
			moradorService.save(novoRepresentante);
			moradorService.save(exRepresentante);
			republicaService.save(republica);
			return true;
		}
		return false;
	}

}
