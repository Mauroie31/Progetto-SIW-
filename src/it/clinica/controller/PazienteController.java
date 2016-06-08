package it.clinica.controller;

import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.clinica.facade.PazienteFacade;
import it.clinica.model.Esame;

@ManagedBean
@RequestScoped
@EJB(name = "pazienteFacade", beanInterface = PazienteFacade.class) 
public class PazienteController {
	@EJB(name = "pazienteFacade")
	private PazienteFacade pazienteFacade;
	private String indirizzo;
	private String ruolo;
	private Map<Long, Esame> esami;
	
	
	//Getters and Setters
	public PazienteFacade getPazienteFacade() {
		return pazienteFacade;
	}
	public void setPazienteFacade(PazienteFacade pazienteFacade) {
		this.pazienteFacade = pazienteFacade;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Map<Long, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<Long, Esame> esami) {
		this.esami = esami;
	}
	
	


}
