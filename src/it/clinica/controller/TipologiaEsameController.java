package it.clinica.controller;

import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;


import it.clinica.facade.*;
import it.clinica.model.*;


@ManagedBean(name="tipologiaEsameController")
public class TipologiaEsameController {
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private PrerequisitoFacade prerequisitoFacade;
	@EJB
	private RisultatoFacade risultatoFacade;

	private String nome;
	private String descrizione;
	private double costo;
	
	//sto provando ad aggiungere i prerequisiti ad una tipologia esame
	private List<Prerequisito> prerequsiti;
	
	public TipologiaEsameController() {

	}


	//	private Set<String> indicatoriEsami;

	//	private Map<Long, Esame> esami;

	//	//caso d'uso UC1
	//	public List<TipologiaEsame> elencoTipologieEsame() {
	//		return this.tipologiaEsameFacade.findAllTipologieEsami();
	//	}
	//	
	//	public String dettagliTipologiaEsame(Long id_tipologia) {
	//		TipologiaEsame tipologiaEsame = this.tipologiaEsameFacade.findTipologiaEsame(id_tipologia);
	//		return tipologiaEsame.getDescrizione();
	//	}
	//end UC1

	//caso d'uso uc4

	//TODO : metodo per creare TIpologiaEsame da inserire nel db (FACADE)

	public String goToPaginaInserimentoTipologiaEsame() {
		return "/portaleAdmin/inserisciTipologiaEsame.jsp";
	}


	//TODO : inserimento boolean
	public String creaTipologiaEsame() {
		TipologiaEsame t= new TipologiaEsame(nome, descrizione, costo, this.prerequsiti);
		this.tipologiaEsameFacade.inserisciTipologiaEsame(t);
		return "/portaleAdmin/inserimentoTipologiaTerminato.jsp";
	}


	public List<Risultato> getTuttiIRisultati() {
		return this.risultatoFacade.findAllRisultati();
	}
	
	public List<Prerequisito> getTuttiIPrerequisiti(){
		return this.prerequisitoFacade.findAllPrerequisiti();
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}

	//END UC4

	
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

	public List<Prerequisito> getPrerequsiti() {
		return prerequsiti;
	}


	public void setPrerequsiti(List<Prerequisito> prerequsiti) {
		this.prerequsiti = prerequsiti;
	}



	//	public Set<String> getIndicatoriEsami() {
	//		return indicatoriEsami;
	//	}
	//	public void setIndicatoriEsami(Set<String> indicatoriEsami) {
	//		this.indicatoriEsami = indicatoriEsami;
	//	}
	//	public Map<Long, Esame> getEsami() {
	//		return esami;
	//	}
	//	public void setEsami(Map<Long, Esame> esami) {
	//		this.esami = esami;
	//	}

}
