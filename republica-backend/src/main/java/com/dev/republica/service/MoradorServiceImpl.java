package com.dev.republica.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;
import com.dev.republica.repository.MoradorRepository;

@Service
@Transactional
public class MoradorServiceImpl implements MoradorService {

	private MoradorRepository moradorRepository;

	public MoradorServiceImpl(MoradorRepository moradorRepository) {
		this.moradorRepository = moradorRepository;
	}

	public List<Morador> getAllMoradores() {
		return moradorRepository.findAll();
	}

	public Morador getMorador(Long id) {
		return moradorRepository.findById(id).orElse(null);
	}

	public Morador save(Morador morador) {
		return moradorRepository.save(morador);
	}

	public Morador update(Long id, Morador morador) {
		Morador m = moradorRepository.getOne(id);
		m.setNome(morador.getNome());
		m.setApelido(morador.getApelido());
		m.setTelefone(morador.getTelefone());
		m.setLink(morador.getLink());
		m.setTelefoneResponsavel1(morador.getTelefoneResponsavel1());
		m.setTelefoneResponsavel2(morador.getTelefoneResponsavel2());
		m.setSexo(morador.getSexo());
		return moradorRepository.save(m);
	}

	public ResponseEntity<?> deleteById(Long id) {
		return moradorRepository.findById(id).map(record -> {
			moradorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public List<Morador> getMoradoresByRepublica(Republica republica) {
		return moradorRepository.findByRepublica(republica);
	}

}
