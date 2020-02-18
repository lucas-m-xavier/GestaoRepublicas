package com.dev.republica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Morador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	// @NotNull
	private String apelido;

	// @NotNull
	private String telefone;

	// @NotNull
	private String link;

	// @NotNull
	private String telefoneResponsavel1;

	// @NotNull
	private String telefoneResponsavel2;

	// @NotNull
	private String sexo;

	@NotNull
	private boolean representante;

	@ManyToOne
	//@JsonIgnoreProperties({ "moradores", "representante" })
	private Republica republica;

	@OneToMany(mappedBy = "pk.morador")
	@JsonIgnore
	private List<MoradorReceitaDespesa> moradorReceitaDespesas = new ArrayList<>();

	public Morador() {
	}

	public Morador(Long id, @NotNull String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Morador(Long id, @NotNull String nome, Republica republica) {
		this.id = id;
		this.nome = nome;
		this.republica = republica;
	}

	public Morador(Long id, @NotNull String nome, @NotNull String apelido, @NotNull String telefone,
			@NotNull String link, @NotNull String telefoneResponsavel1, @NotNull String telefoneResponsavel2,
			@NotNull String sexo, @NotNull boolean representante, Republica republica,
			List<MoradorReceitaDespesa> moradorReceitaDespesas) {
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.telefone = telefone;
		this.link = link;
		this.telefoneResponsavel1 = telefoneResponsavel1;
		this.telefoneResponsavel2 = telefoneResponsavel2;
		this.sexo = sexo;
		this.representante = representante;
		this.republica = republica;
		this.moradorReceitaDespesas = moradorReceitaDespesas;
	}

	@Transient
	@JsonIgnore
	public float getValorDividaReceitaDespesa() {
		float soma = 0f;
		List<MoradorReceitaDespesa> moradorReceitaDespesa = getMoradorReceitaDespesas();
		for (MoradorReceitaDespesa mrd : moradorReceitaDespesa) {
			if (mrd.getPk().getReceitaDespesa().getTipo().equals("Despesa"))
				soma += mrd.getValor();
		}
		return soma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTelefoneResponsavel1() {
		return telefoneResponsavel1;
	}

	public void setTelefoneResponsavel1(String telefoneResponsavel1) {
		this.telefoneResponsavel1 = telefoneResponsavel1;
	}

	public String getTelefoneResponsavel2() {
		return telefoneResponsavel2;
	}

	public void setTelefoneResponsavel2(String telefoneResponsavel2) {
		this.telefoneResponsavel2 = telefoneResponsavel2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isRepresentante() {
		return representante;
	}

	public void setRepresentante(boolean representante) {
		this.representante = representante;
	}

	public Republica getRepublica() {
		return republica;
	}

	public void setRepublica(Republica republica) {
		this.republica = republica;
	}

	public List<MoradorReceitaDespesa> getMoradorReceitaDespesas() {
		return moradorReceitaDespesas;
	}

	public void setMoradorReceitaDespesas(List<MoradorReceitaDespesa> moradorReceitaDespesas) {
		this.moradorReceitaDespesas = moradorReceitaDespesas;
	}

	public Long getId() {
		return id;
	}

}
