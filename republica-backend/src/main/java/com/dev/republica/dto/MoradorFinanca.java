package com.dev.republica.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;

public class MoradorFinanca {

	private Republica republica;

	private String tipo; // despesa ou receita

	private String descricao;

	private float valor;

	private String periodo; // mensal //semestral //indefinido;

	private boolean divisao; // para todos os membros ou não

	private float valorDividido;

	private Date dataLancamento;

	private Date dataVencimentoRecebimento;

	private boolean efetivado;

	private List<Morador> moradores = new ArrayList<>();
	
	

	public MoradorFinanca() {
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

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

}
