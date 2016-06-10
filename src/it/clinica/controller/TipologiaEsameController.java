package it.clinica.controller;

import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import it.clinica.facade.TipologiaEsameFacade;
import it.clinica.model.Esame;
import it.clinica.model.TipologiaEsame;

@ManagedBean
@RequestScoped
@EJB(name = "tipologiaEsameFacade", beanInterface = TipologiaEsameFacade.class) 
public class TipologiaEsameController {
	
	@EJB(name = "tipologiaEsameFacade")
	
	private TipologiaEsameFacade tipologiaEsameFacade;
	
	private Long id;
	private String nome;
	private String descrizione;
	private double costo;
	
	
	private Set<String> indicatoriEsami;
	
	private Map<String, String> prerequisiti;
	
	private Map<Long, Esame> esami;
	
	//caso d'uso UC1
	public List<TipologiaEsame> elencoTipologieEsame() {
		return this.tipologiaEsameFacade.findAllTipologieEsami();
	}
	
	public String dettagliTipologiaEsame(Long id_tipologia) {
		TipologiaEsame tipologiaEsame = tipologiaEsameFacade.findTipologiaEsame(id_tipologia);
		return tipologiaEsame.getDescrizione();
	}
	//end UC1
	
	//Il settaggio di una tipologia esame non è richiesta nei casi d'uso
	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	public Set<String> getIndicatoriEsami() {
		return indicatoriEsami;
	}
	public void setIndicatoriEsami(Set<String> indicatoriEsami) {
		this.indicatoriEsami = indicatoriEsami;
	}
	public Map<String, String> getPrerequisiti() {
		return prerequisiti;
	}
	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
	public Map<Long, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<Long, Esame> esami) {
		this.esami = esami;
	}
	
}
