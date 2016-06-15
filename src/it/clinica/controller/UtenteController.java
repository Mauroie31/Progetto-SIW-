package it.clinica.controller;

import java.util.List;

import it.clinica.facade.*;
import it.clinica.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="utenteController")
@SessionScoped
public class UtenteController {
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	@EJB
	private PrerequisitoFacade prerequisitoFacade;
	@EJB
	private RisultatoFacade risultatoFacade;
	
	private String nomeTipologia, descrizioneTipologia;
	private double costoTipologia;
	private TipologiaEsame tipologiaEsame;

	@ManagedProperty(value = "#{utenteManager}")
	private UtenteManager session;


	public UtenteManager getSession() {
		return session;
	}

	public void setSession(UtenteManager session) {
		this.session = session;
	}

	public UtenteController() {		
	}
	
	public String goToPortalePaziente() {
		return "/portalePaziente/portalePaziente.jsp";
	}

	@PostConstruct
	public void init() {
		UtenteManager.sessionCheckerUtenteAmministratore();
	}
	
	public String logout() {
		return this.session.logout();
	}


	public String creaTipologiaEsame() {
		this.tipologiaEsame = new TipologiaEsame(nomeTipologia, descrizioneTipologia, costoTipologia);
		this.tipologiaEsameFacade.inserisciTipologiaEsame(this.tipologiaEsame);
		return "/portaleAdmin/inserimentoPrerequisitiRisultatiPerTipologiaEsame.jsp";
	}
	
	public List<Prerequisito> getTuttiIPrerequisiti() {
		return this.prerequisitoFacade.findAllPrerequisiti();
	}
	
	public void addPrerequisiti(Prerequisito p){
		this.tipologiaEsameFacade.aggiorna(this.tipologiaEsame.getId(), p);
	}
	
	public List<Risultato> getTuttiIRisultati() {
		return this.risultatoFacade.findAllRisultati();
	}
	
	public void addRisultati(Risultato r) {
		this.tipologiaEsameFacade.aggiorna(this.tipologiaEsame.getId(), r);
	}
	
	public String tipologiaInserita() {
		return "/portaleAdmin/inserimentoTipologiaTerminato.jsp";
	}

	public String getNomeTipologia() {
		return nomeTipologia;
	}

	public void setNomeTipologia(String nomeTipologia) {
		this.nomeTipologia = nomeTipologia;
	}

	public double getCostoTipologia() {
		return costoTipologia;
	}

	public void setCostoTipologia(double costoTipologia) {
		this.costoTipologia = costoTipologia;
	}

	public String getDescrizioneTipologia() {
		return descrizioneTipologia;
	}

	public void setDescrizioneTipologia(String descrizioneTipologia) {
		this.descrizioneTipologia = descrizioneTipologia;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
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
}