package it.clinica.controller;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;



import javax.faces.bean.SessionScoped;

import it.clinica.facade.*;
import it.clinica.model.*;


@ManagedBean(name="tipologiaEsameController")
@SessionScoped
public class TipologiaEsameController {
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private PrerequisitoFacade prerequisitoFacade;
	@EJB
	private RisultatoFacade risultatoFacade;

	private Long id;
	private String nome;
	private String descrizione;
	private double costo;
	private TipologiaEsame tipologia;
	private List<TipologiaEsame> tipologieEsami;
	private List<Prerequisito> prerequisiti;
	private List<Risultato> risultati;

	public TipologiaEsameController() {
	}
	
	@PostConstruct
	public void init(){
		this.tipologieEsami = this.tipologiaEsameFacade.findAllTipologieEsami();
	}

	//CASO d'USO UC1
	public String goToElencoTipologie() {
		return "/portaleUtenteNonRegistrato/consultaElencoTipologiaEsame.jsp";
	}

	public PrerequisitoFacade getPrerequisitoFacade() {
		return prerequisitoFacade;
	}

	public void setPrerequisitoFacade(PrerequisitoFacade prerequisitoFacade) {
		this.prerequisitoFacade = prerequisitoFacade;
	}

	public RisultatoFacade getRisultatoFacade() {
		return risultatoFacade;
	}

	public void setRisultatoFacade(RisultatoFacade risultatoFacade) {
		this.risultatoFacade = risultatoFacade;
	}

	public List<TipologiaEsame> getTipologieEsami() {
		return tipologieEsami;
	}

	public void setTipologieEsami(List<TipologiaEsame> tipologieEsami) {
		this.tipologieEsami = tipologieEsami;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public String vaiSuPaginaDettagliTipologia(Long id_tipologia) {
		this.tipologia = this.tipologiaEsameFacade.findTipologiaEsame(id_tipologia);
		return "/portaleUtenteNonRegistrato/dettaglioTipologiaEsame.jsp";
	}

	public String richiediDettagliTipologia(TipologiaEsame tipologia) {
		return tipologia.getDescrizione();
	}
	
	public List<Prerequisito> getPrerequisitiDellaTipologiaEsame(Long id_tipologiaEsame) {
		return this.prerequisitoFacade.findPrerequisitiTipologiaEsame(id_tipologiaEsame);
	}

	//END caso d'uso UC1


	//caso d'uso uc4

	//TODO : metodo per creare TIpologiaEsame da inserire nel db (FACADE)

	public String goToPaginaInserimentoTipologiaEsame() {
		return "/portaleAdmin/inserisciTipologiaEsame.jsp";
	}


	public String creaTipologiaEsame() {
		this.tipologia = new TipologiaEsame(nome, descrizione, costo);
		this.tipologiaEsameFacade.inserisciTipologiaEsame(this.tipologia);
		return "/portaleAdmin/inserimentoPrerequisitiRisultatiPerTipologiaEsame.jsp";
	}

	public List<Prerequisito> getTuttiIPrerequisiti() {
		return this.prerequisitoFacade.findAllPrerequisiti();
	}
	
	public List<Risultato> getTuttiIRisultati() {
		return this.risultatoFacade.findAllRisultati();
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}

	public void addPrerequisiti(Prerequisito p){
		this.tipologiaEsameFacade.aggiorna(this.tipologia.getId(), p);
	}
	
	public void addRisultati(Risultato r) {
		this.tipologiaEsameFacade.aggiorna(this.tipologia.getId(), r);
	}
	
	public String tipologiaInserita() {
		return "/portaleAdmin/inserimentoTipologiaTerminato.jsp";
	}

	//END UC4



	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TipologiaEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public List<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}


	//  public Set<String> getIndicatoriEsami() {
		//      return indicatoriEsami;
		//  }
	//  public void setIndicatoriEsami(Set<String> indicatoriEsami) {
		//      this.indicatoriEsami = indicatoriEsami;
	//  }
	//  public Map<Long, Esame> getEsami() {
	//      return esami;
	//  }
	//  public void setEsami(Map<Long, Esame> esami) {
	//      this.esami = esami;
	//  }

}