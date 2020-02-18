package com.dev.republica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Republica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String endereco;

	@NotNull
	private byte numeroVagas;

	@NotNull
	private String tipoLocacao;

	@NotNull
	private String genero;

	@OneToMany(mappedBy = "republica")
	@JsonIgnoreProperties("republica")
	private List<Morador> moradores = new ArrayList<>();

	@NotNull
	private byte numeroComodos;

	@NotNull
	private String utensilios;

	@NotNull
	private String diferencial;

	@NotNull
	private byte numeroVagasDisponiveis;

	@NotNull
	private String descricao;

	@OneToOne
	@JsonIgnoreProperties("republica")
	private Morador representante;

	@NotNull
	private String link;

	public Republica(Long id, @NotNull String nome, @NotNull String endereco, @NotNull byte numeroVagas,
			@NotNull String tipoLocacao, @NotNull String genero, @NotNull List<Morador> moradores,
			@NotNull byte numeroComodos, @NotNull String utensilios, @NotNull String diferencial,
			@NotNull byte numeroVagasDisponiveis, @NotNull String descricao, @NotNull Morador representante,
			@NotNull String link) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numeroVagas = numeroVagas;
		this.tipoLocacao = tipoLocacao;
		this.genero = genero;
		this.moradores = moradores;
		this.numeroComodos = numeroComodos;
		this.utensilios = utensilios;
		this.diferencial = diferencial;
		this.numeroVagasDisponiveis = numeroVagasDisponiveis;
		this.descricao = descricao;
		this.representante = representante;
		this.link = link;
	}

	public Republica(Long id, @NotNull String nome, @NotNull String endereco, @NotNull byte numeroVagas,
			@NotNull String tipoLocacao, @NotNull String genero, @NotNull byte numeroComodos,
			@NotNull String utensilios, @NotNull String diferencial, @NotNull String descricao,
			@NotNull Morador representante, @NotNull String link) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numeroVagas = numeroVagas;
		this.tipoLocacao = tipoLocacao;
		this.genero = genero;
		this.numeroComodos = numeroComodos;
		this.utensilios = utensilios;
		this.diferencial = diferencial;
		this.numeroVagasDisponiveis = (byte) (this.getNumeroVagas() - 1);
		this.descricao = descricao;
		this.representante = representante;
		this.link = link;

		this.moradores.add(representante);
		representante.setRepresentante(true);
	}

	public Republica() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public byte getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(byte numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public String getTipoLocacao() {
		return tipoLocacao;
	}

	public void setTipoLocacao(String tipoLocacao) {
		this.tipoLocacao = tipoLocacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

	public boolean addMorador(Morador morador) {
		if (this.getNumeroVagasDisponiveis() > 0) {
			this.moradores.add(morador);
			this.setNumeroVagasDisponiveis((byte) (this.getNumeroVagasDisponiveis() - 1));
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Morador morador) {
		if (moradores.remove(morador)) {
			this.setNumeroVagasDisponiveis((byte) (this.getNumeroVagasDisponiveis() + 1));
			return true;
		} else {
			return false;
		}
	}

	public byte getNumeroComodos() {
		return numeroComodos;
	}

	public void setNumeroComodos(byte numeroComodos) {
		this.numeroComodos = numeroComodos;
	}

	public String getUtensilios() {
		return utensilios;
	}

	public void setUtensilios(String utensilios) {
		this.utensilios = utensilios;
	}

	public String getDiferencial() {
		return diferencial;
	}

	public void setDiferencial(String diferencial) {
		this.diferencial = diferencial;
	}

	public byte getNumeroVagasDisponiveis() {
		return numeroVagasDisponiveis;
	}

	public void setNumeroVagasDisponiveis(byte numeroVagasDisponiveis) {
		this.numeroVagasDisponiveis = numeroVagasDisponiveis;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Morador getRepresentante() {
		return representante;
	}

	public void setRepresentante(Morador representante) {
		this.representante = representante;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}	

}
