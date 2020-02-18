package com.dev.republica.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MoradorReceitaDespesa {

	@EmbeddedId
	private MoradorReceitaDespesaId pk;

	private float valor;

	private float valorPago;

	public MoradorReceitaDespesa() {
	}

	public MoradorReceitaDespesa(Morador morador, ReceitaDespesa receitaDespesa, float valor, float valorPago) {
		pk = new MoradorReceitaDespesaId();
		pk.setMorador(morador);
		pk.setReceitaDespesa(receitaDespesa);
		this.valor = valor;
		this.valorPago = valorPago;
	}

	public MoradorReceitaDespesaId getPk() {
		return pk;
	}

	public void setPk(MoradorReceitaDespesaId pk) {
		this.pk = pk;
	}

	// @JsonIgnoreProperties({"moradorReceitaDespesas"})
	@JsonIgnore
	public ReceitaDespesa getReceitaDespesa() {
		return pk.getReceitaDespesa();
	}

	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler",
	// "moradorReceitaDespesas", "republica"})
	@JsonIgnore
	public Morador getMorador() {
		return pk.getMorador();
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

}
