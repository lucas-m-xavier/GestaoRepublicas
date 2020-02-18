package com.dev.republica.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;
import com.dev.republica.repository.RepublicaRepository;

@Service
@Transactional
public class RepublicaServiceImpl implements RepublicaService {

	private RepublicaRepository republicaRepository;

	public RepublicaServiceImpl(RepublicaRepository republicaRepository) {
		this.republicaRepository = republicaRepository;
	}

	public List<Republica> getAllRepublicas() {
		return republicaRepository.findAll();
	}

	public Republica getRepublica(Long id) {
		return republicaRepository.findById(id).orElse(null);
	}

	public Republica save(Republica republica) {
		return republicaRepository.save(republica);
	}

	public ResponseEntity<Republica> update(Long id, Republica republica) {
		return republicaRepository.findById(id).map(record -> {
			record.setNome(republica.getNome());
			record.setEndereco(republica.getEndereco());
			record.setNumeroVagas(republica.getNumeroVagas());
			record.setTipoLocacao(republica.getTipoLocacao());
			record.setGenero(republica.getGenero());
			record.setMoradores(republica.getMoradores());
			record.setNumeroComodos(republica.getNumeroComodos());
			record.setUtensilios(republica.getUtensilios());
			record.setDiferencial(republica.getDiferencial());
			record.setNumeroVagasDisponiveis(republica.getNumeroVagasDisponiveis());
			record.setDescricao(republica.getDescricao());
			record.setRepresentante(republica.getRepresentante());
			record.setLink(republica.getLink());
			Republica updated = save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> deleteById(Long id) {
		return republicaRepository.findById(id).map(record -> {
			republicaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public List<Republica> getRepublicasDisponiveis() {
		return republicaRepository.findByNumeroVagasDisponiveisGreaterThanEqual((byte) 1);
	}

	public Republica addMorador(Republica republica, Morador morador) {
		morador.setRepublica(republica);
		return republica;
	}

}
