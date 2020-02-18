package com.dev.republica.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long historicoId;
	
	@NotNull
	private String nomeRep;
	
	private Date dataSaida;
	
	@NotNull
	private Date dataEntrada;
	
	private int tempo;
	
	@NotNull
	@ManyToOne
	private Morador morador;

	public Historico(Long historicoId, @NotNull String nomeRep, Date dataSaida, @NotNull Date dataEntrada,
			int tempo, Morador morador) {
		this.historicoId = historicoId;
		this.nomeRep = nomeRep;
		this.dataSaida = dataSaida;
		this.dataEntrada = dataEntrada;
		this.tempo = tempo;
		this.morador = morador;
	}
	
	public Historico(Long historicoId, @NotNull String nomeRep, Date dataSaida, @NotNull Date dataEntrada,
			Morador morador) {
		this.historicoId = historicoId;
		this.nomeRep = nomeRep;
		this.dataSaida = dataSaida;
		this.dataEntrada = dataEntrada;
		this.morador = morador;
	}
	
	public Historico() {
	}

	public Long getHistoricoId() {
		return historicoId;
	}

	public void setHistoricoId(Long historicoId) {
		this.historicoId = historicoId;
	}

	public String getNomeRep() {
		return nomeRep;
	}

	public void setNomeRep(String nomeRep) {
		this.nomeRep = nomeRep;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	

}
