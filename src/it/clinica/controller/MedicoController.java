package it.clinica.controller;

import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import it.clinica.facade.MedicoFacade;
import it.clinica.model.Esame;
import it.clinica.model.TipologiaEsame;

@ManagedBean(name="medicoController")
@RequestScoped
public class MedicoController {
	@EJB(name="medicoFacade")
	private MedicoFacade medicoFacade;
	private Long id;
	private String nome;
	private String cognome;
	private TipologiaEsame specializzazione;
	private Map<Long, Esame> esami;
	
	public MedicoController() {
		
	}
	
	
	
	//Getters and Setters
	public MedicoFacade getMedicoFacade() {
		return medicoFacade;
	}
	public void setMedicoFacade(MedicoFacade medicoFacade) {
		this.medicoFacade = medicoFacade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public TipologiaEsame getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(TipologiaEsame specializzazione) {
		this.specializzazione = specializzazione;
	}
	public Map<Long, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<Long, Esame> esami) {
		this.esami = esami;
	}
	
	


}
