package com.dev.republica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Republica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@NotNull
	private String integrantes;

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
	private Representante representante;

	@NotNull
	private String link;

	@NotNull
	private String curso;

	public Republica(Long id, @NotNull String nome, @NotNull String endereco, @NotNull byte numeroVagas,
			@NotNull String tipoLocacao, @NotNull String genero, @NotNull String integrantes,
			@NotNull byte numeroComodos, @NotNull String utensilios, @NotNull String diferencial,
			@NotNull byte numeroVagasDisponiveis, @NotNull String descricao, @NotNull Representante representante,
			@NotNull String link, @NotNull String curso) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numeroVagas = numeroVagas;
		this.tipoLocacao = tipoLocacao;
		this.genero = genero;
		this.integrantes = integrantes;
		this.numeroComodos = numeroComodos;
		this.utensilios = utensilios;
		this.diferencial = diferencial;
		this.numeroVagasDisponiveis = numeroVagasDisponiveis;
		this.descricao = descricao;
		this.representante = representante;
		this.link = link;
		this.curso = curso;
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

	public String getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
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

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
