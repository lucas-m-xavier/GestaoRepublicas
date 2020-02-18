package com.dev.republica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReceitaDespesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	@JsonIgnore
	private Republica republica;

	@NotNull
	private String tipo; // despesa ou receita

	@NotNull
	private String descricao;

	@NotNull
	private float valor;

	@NotNull
	private String periodo; // mensal //semestral //indefinido;

	@NotNull
	private boolean divisao; // para todos os membros ou não

	private float valorDividido;

	@NotNull
	private Date dataLancamento;

	@NotNull
	private Date dataVencimentoRecebimento;

	@NotNull
	private boolean efetivado;

	@OneToMany(mappedBy = "pk.receitaDespesa")
	private List<MoradorReceitaDespesa> moradorReceitaDespesas = new ArrayList<>();

	public ReceitaDespesa() {
	}

	public ReceitaDespesa(@NotNull Republica republica, @NotNull String tipo, @NotNull String descricao,
			@NotNull float valor, @NotNull String periodo, @NotNull boolean divisao, float valorDividido,
			@NotNull Date dataLancamento, @NotNull Date dataVencimentoRecebimento, @NotNull boolean efetivado) {
		this.republica = republica;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.periodo = periodo;
		this.divisao = divisao;
		this.valorDividido = valorDividido;
		this.dataLancamento = dataLancamento;
		this.dataVencimentoRecebimento = dataVencimentoRecebimento;
		this.efetivado = efetivado;
	}

	public ReceitaDespesa(Long id, @NotNull Republica republica, @NotNull String tipo, @NotNull String descricao,
			@NotNull float valor, @NotNull String periodo, @NotNull boolean divisao, float valorDividido,
			@NotNull Date dataLancamento, @NotNull Date dataVencimentoRecebimento, @NotNull boolean efetivado) {
		this.id = id;
		this.republica = republica;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.periodo = periodo;
		this.divisao = divisao;
		this.valorDividido = valorDividido;
		this.dataLancamento = dataLancamento;
		this.dataVencimentoRecebimento = dataVencimentoRecebimento;
		this.efetivado = efetivado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Republica getRepublica() {
		return republica;
	}

	public void setRepublica(Republica republica) {
		this.republica = republica;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public boolean isDivisao() {
		return divisao;
	}

	public void setDivisao(boolean divisao) {
		this.divisao = divisao;
	}

	public float getValorDividido() {
		return valorDividido;
	}

	public void setValorDividido(float valorDividido) {
		this.valorDividido = valorDividido;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataVencimentoRecebimento() {
		return dataVencimentoRecebimento;
	}

	public void setDataVencimentoRecebimento(Date dataVencimentoRecebimento) {
		this.dataVencimentoRecebimento = dataVencimentoRecebimento;
	}

	public boolean isEfetivado() {
		return efetivado;
	}

	public void setEfetivado(boolean efetivado) {
		this.efetivado = efetivado;
	}

	public List<MoradorReceitaDespesa> getMoradorReceitaDespesas() {
		return moradorReceitaDespesas;
	}

	public void setMoradorReceitaDespesas(List<MoradorReceitaDespesa> moradorReceitaDespesas) {
		this.moradorReceitaDespesas = moradorReceitaDespesas;
	}

}
