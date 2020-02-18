package com.dev.republica.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "idMorador", referencedColumnName = "id")
    private Morador morador;

    @ManyToOne
    @JoinColumn(name = "idRepublica", referencedColumnName = "id")
    private Republica republica;

    private String status;
    private String tipo;
    private String descricao;
    private LocalDate dataFeedback;
    private LocalDate dataSolucao;
    private boolean anonimo;
    private int idade;
    
	public Feedback(Long id, Morador morador, Republica republica, String status, String tipo, String descricao,
			LocalDate dataFeedback, LocalDate dataSolucao, boolean anonimo, int idade) {
		super();
		this.id = id;
		this.morador = morador;
		this.republica = republica;
		this.status = status;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataFeedback = dataFeedback;
		this.dataSolucao = dataSolucao;
		this.anonimo = anonimo;
		this.idade = idade;
	}

	public Feedback() {
	}

	public Long getId() {
		return id;
	}

	public Morador getmorador() {
		return morador;
	}

	public void setmorador(Morador morador) {
		this.morador = morador;
	}

	public Republica getRepublica() {
		return republica;
	}

	public void setRepublica(Republica republica) {
		this.republica = republica;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public LocalDate getDataFeedback() {
		return dataFeedback;
	}

	public void setDataFeedback(LocalDate dataFeedback) {
		this.dataFeedback = dataFeedback;
	}

	public LocalDate getDataSolucao() {
		return dataSolucao;
	}

	public void setDataSolucao(LocalDate dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
    	
}
