package com.dev.republica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;
import com.dev.republica.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByRepublica(Republica republica);

	@Query("select t from Tarefa t join fetch t.moradores mrd where t.republica = ?1 and mrd.pk.morador = ?2")
	List<Tarefa> findByRepublicaAndMorador(Republica republica, Morador morador);

}
