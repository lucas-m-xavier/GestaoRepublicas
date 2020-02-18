package com.dev.republica.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
public class MoradorTarefaId implements Serializable {

	private static final long serialVersionUID = -7680957839457705066L;

	@ManyToOne
	private Morador morador;

	@ManyToOne
	private Tarefa tarefa;

	public MoradorTarefaId() {
	}

	public MoradorTarefaId(Morador morador, Tarefa tarefa) {
		this.morador = morador;
		this.tarefa = tarefa;
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "moradorReceitaDespesas", "republica" })
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	@JsonIgnoreProperties({ "moradores" })
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
