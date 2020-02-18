package com.dev.republica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.republica.dto.MoradorFinanca;
import com.dev.republica.model.Morador;
import com.dev.republica.model.MoradorReceitaDespesa;
import com.dev.republica.model.MoradorReceitaDespesaId;
import com.dev.republica.model.ReceitaDespesa;
import com.dev.republica.model.Republica;
import com.dev.republica.service.MoradorReceitaDespesaService;
import com.dev.republica.service.MoradorService;
import com.dev.republica.service.ReceitaDespesaService;
import com.dev.republica.service.RepublicaService;

@RestController
@RequestMapping("/republica/receitasdespesas")
@CrossOrigin
public class ReceitaDespesaController {

	private ReceitaDespesaService receitaDespesaService;
	private RepublicaService republicaService;
	private MoradorReceitaDespesaService moradorReceitaDespesaService;
	private MoradorService moradorService;

	public ReceitaDespesaController(ReceitaDespesaService receitaDespesaService, RepublicaService republicaService,
			MoradorReceitaDespesaService moradorReceitaDespesaService, MoradorService moradorService) {
		this.receitaDespesaService = receitaDespesaService;
		this.republicaService = republicaService;
		this.moradorReceitaDespesaService = moradorReceitaDespesaService;
		this.moradorService = moradorService;
	}

	@GetMapping(path = { "/{id}" })
	public ReceitaDespesa getReceitaDespesaById(@PathVariable Long id) {
		return receitaDespesaService.getReceitaDespesa(id);
	}

	@PostMapping
	public ReceitaDespesa create(@RequestBody MoradorFinanca form) {
		ReceitaDespesa rd = new ReceitaDespesa();
		rd.setRepublica(form.getRepublica());
		rd.setTipo(form.getTipo());
		rd.setDescricao(form.getDescricao());
		rd.setValor(form.getValor());
		rd.setPeriodo(form.getPeriodo());
		rd.setDivisao(form.isDivisao());
		rd.setValorDividido((float) form.getValor() / form.getMoradores().size());
		rd.setDataLancamento(form.getDataLancamento());
		rd.setDataVencimentoRecebimento(form.getDataVencimentoRecebimento());
		rd.setEfetivado(form.isEfetivado());
		receitaDespesaService.save(rd);

		List<MoradorReceitaDespesa> moradorReceitaDespesas = new ArrayList<>();

		for (Morador morador : form.getMoradores()) {
			moradorReceitaDespesas.add(moradorReceitaDespesaService
					.save(new MoradorReceitaDespesa(morador, rd, rd.getValorDividido(), 0)));
		}
		rd.setMoradorReceitaDespesas(moradorReceitaDespesas);
		return receitaDespesaService.save(rd);
	}

	@PostMapping(value = "/estornar")
	public ReceitaDespesa estornar(@RequestBody ReceitaDespesa rd) {

		rd = receitaDespesaService.getReceitaDespesa(rd.getId());

		ReceitaDespesa receitaDespesa = new ReceitaDespesa();
		receitaDespesa.setRepublica(rd.getRepublica());
		receitaDespesa.setValor(rd.getValor());
		receitaDespesa.setPeriodo(rd.getPeriodo());
		receitaDespesa.setDivisao(rd.isDivisao());
		receitaDespesa.setValorDividido(rd.getValorDividido());
		receitaDespesa.setDataLancamento(rd.getDataLancamento());
		receitaDespesa.setDataVencimentoRecebimento(rd.getDataVencimentoRecebimento());
		receitaDespesa.setEfetivado(rd.isEfetivado());

		receitaDespesa.setDescricao("Estorno ".concat(rd.getDescricao()));

		if (rd.getTipo().equals("Despesa"))
			receitaDespesa.setTipo("Receita");
		else
			receitaDespesa.setTipo("Despesa");

		receitaDespesaService.save(receitaDespesa);

		List<MoradorReceitaDespesa> moradorReceitaDespesas = new ArrayList<>();

		for (MoradorReceitaDespesa moradorRD : rd.getMoradorReceitaDespesas()) {
			System.out.println("entrou");

			moradorReceitaDespesas
					.add(moradorReceitaDespesaService.save(new MoradorReceitaDespesa(moradorRD.getPk().getMorador(),
							receitaDespesa, receitaDespesa.getValorDividido(), receitaDespesa.getValorDividido())));
			moradorRD.setValorPago(moradorRD.getValor());
		}

		receitaDespesa.setMoradorReceitaDespesas(moradorReceitaDespesas);

		return receitaDespesaService.save(receitaDespesa);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ReceitaDespesa> update(@PathVariable("id") Long id,
			@RequestBody ReceitaDespesa receitaDespesa) {
		return receitaDespesaService.update(id, receitaDespesa);
	}

	@GetMapping(path = { "republica/{id}" })
	public List<ReceitaDespesa> getReceitaDespesaByRepublica(@PathVariable Long id) {
		Republica republica = republicaService.getRepublica(id);
		return receitaDespesaService.getReceitaDespesaByRepublica(republica);
	}

	@GetMapping(path = { "republica/{idRepublica}/morador/{idMorador}" })
	public List<ReceitaDespesa> getReceitaDespesaByMorador(@PathVariable Long idRepublica,
			@PathVariable Long idMorador) {
		Republica republica = republicaService.getRepublica(idRepublica);
		Morador morador = moradorService.getMorador(idMorador);
		return receitaDespesaService.getReceitaDespesaByRepublicaAndMorador(republica, morador);
	}

	@GetMapping(path = { "republica/{idRepublica}/morador/{idMorador}/pagar/{idReceitaDespesa}" })
	public void pagarReceitaDespesa(@PathVariable Long idRepublica, @PathVariable Long idMorador,
			@PathVariable Long idReceitaDespesa) {
		Morador morador = moradorService.getMorador(idMorador);
		ReceitaDespesa receitaDespesa = receitaDespesaService.getReceitaDespesa(idReceitaDespesa);
		MoradorReceitaDespesaId mrdId = new MoradorReceitaDespesaId();
		mrdId.setMorador(morador);
		mrdId.setReceitaDespesa(receitaDespesa);
		MoradorReceitaDespesa mrd = moradorReceitaDespesaService.getMoradorReceitaDespesa(mrdId);
		mrd.setValorPago(mrd.getValor());
		moradorReceitaDespesaService.save(mrd);
	}

}
