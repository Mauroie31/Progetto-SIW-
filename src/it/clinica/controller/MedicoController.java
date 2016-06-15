package it.clinica.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.clinica.facade.*;
import it.clinica.model.*;


@ManagedBean(name="medicoController")
@SessionScoped
public class MedicoController {
	
	@EJB(name="medicoFacade")
	private MedicoFacade medicoFacade;
	
	@EJB(name="esameFacade")
	private EsameFacade esameFacade;
	
	//non servono al fine del caso d'uso 5
	private String nome;
	private String cognome;
	private TipologiaEsame specializzazione;
	
	private List<Esame> esami;

	private Medico medico;
	
	public MedicoController() {
		
	}
	
	public String cercaMedico(){
		this.medico =this.medicoFacade.findMedicoByNome(this.nome);
		System.out.println(this.medico.getNome());
		System.out.println(this.medico.getEsami());
		this.setEsami(this.medico.getEsami());
		return "/portaleAdmin/mostraEsamiMedico.jsp";
	}
	
	public List<Esame> getTuttigliEsamiDelMedico(){
		return this.medico.getEsami();
	}
	
	
	
	//Getters and Setters
	public MedicoFacade getMedicoFacade() {
		return medicoFacade;
	}
	public void setMedicoFacade(MedicoFacade medicoFacade) {
		this.medicoFacade = medicoFacade;
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
	public void setMedico(Medico medico){
		this.medico=medico;
	}
	public Medico getMedico(){
		return this.medico;
	}

	public List<Esame> getEsami() {
		return this.esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public EsameFacade getEsameFacade() {
		return this.esameFacade;
	}

	public void setEsameFacade(EsameFacade esameFacade) {
		this.esameFacade = esameFacade;
	}
}