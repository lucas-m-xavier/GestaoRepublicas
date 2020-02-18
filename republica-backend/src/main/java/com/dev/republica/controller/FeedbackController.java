package com.dev.republica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.republica.model.Feedback;
import com.dev.republica.model.Morador;
import com.dev.republica.model.Republica;
import com.dev.republica.service.FeedbackService;
import com.dev.republica.service.MoradorService;
import com.dev.republica.service.RepublicaService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private MoradorService moradorService;
	
	@Autowired
	private RepublicaService republicaService;

	public FeedbackController(FeedbackService feedbackService, MoradorService moradorService,
			RepublicaService republicaService) {
		this.feedbackService = feedbackService;
		this.moradorService = moradorService;
		this.republicaService = republicaService;
	}
	
	@GetMapping(path = { "/{id}" })
	public Feedback getFeedback(@PathVariable Long id) {
		return feedbackService.getFeedbackById(id);		
	}
	
	@GetMapping(path = { "/republica/{id}" })
	public List<Feedback> getFeedbackByRepublica(@PathVariable Long id) {
		Republica republica = republicaService.getRepublica(id);
		return feedbackService.getFeedbackByRepublica(republica);
	}
	
	@GetMapping(path = { "/republica/{idRepublica}/morador/{idMorador}" })
	public List<Feedback> getFeedbackByMoradorAndRepublica
		(@PathVariable Long idRepublica, @PathVariable Long idMorador) {
		
		Republica republica = republicaService.getRepublica(idRepublica);
		Morador morador = moradorService.getMorador(idMorador);
		
		return feedbackService.getFeedbackByRepublicaAndMorador(republica, morador);
	}
		
	@PostMapping
	public Feedback create(@RequestBody Feedback feedback) {
		feedback.setStatus("ABERTO");
		return feedbackService.save(feedback);
	}
	
	@PutMapping
	public Feedback update(@RequestBody Feedback feedback) {
		return feedbackService.save(feedback);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Feedback delete(@PathVariable Long id) {
		Feedback feedback = feedbackService.getFeedbackById(id);
		feedback.setStatus("EXCLUIDO");
		return feedbackService.save(feedback);		
	}
	
}
