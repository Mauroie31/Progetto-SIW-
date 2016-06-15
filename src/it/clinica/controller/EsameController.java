package it.clinica.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import it.clinica.facade.*;
import it.clinica.model.*;



@ManagedBean(name="esameController")
@SessionScoped
public class EsameController  {
	 
	@EJB(name = "esameFacade")
	private EsameFacade esameFacade;
	@EJB(name = "utenteFacade")
	private UtenteFacade utenteFacade;
	@EJB(name = "tipolgiaEsameFacade")
	private TipologiaEsameFacade tipologiaEsamefacade;
	@EJB(name = "medicoFacade")
	private MedicoFacade medicoFacade;
	
	private Date dataPrenotazione;
	private Date dataVisita;

	
	private Esame esame;
	private Utente paziente;
	private String id_utente;
	private Medico medico;
	private String nome_medico;
	private TipologiaEsame tipologia;

//	private List<Risultato> risultati; //serve per il caso d'uso 3



//	@ManagedProperty(value = "#{utenteManager}")
//	private UtenteManager session;

	//Caso d'uso UC2
	public String creaEsame() {
		this.esame=this.esameFacade.createEsame(this.dataVisita);
		Long id_paziente = Long.valueOf(this.id_utente).longValue();
		this.paziente = this.utenteFacade.findUtenteById(id_paziente);
		this.esameFacade.associaPazienteAdEsame(this.paziente, this.esame);
		this.medico =this.medicoFacade.findMedicoByNome(this.nome_medico);
		this.esameFacade.associaMedicoAdEsame(this.medico, this.esame);
		return "/portaleAdmin/dettagliPrenotazioneEsame.jsp";
	}
	

	public String goToPaginaFineInserimentoPrenotazioneEsame() {
		return "/portaleAdmin/fineInserimentoPrenotazioneEsame.jsp";
	}
	
	public String setTipologiaPerPrenotazioneEsame(TipologiaEsame tipologia){
		this.esameFacade.associaTipologiaEsameAdEsame(tipologia);
		return "/portaleAdmin/dettagliPrenotazioneEsame.jsp";
	}
	
	//fine caso d'uso UC2

	



	//Getters and Setters
	
	public EsameFacade getEsameFacade() {
		return esameFacade;
	}
	
	public void setEsameFacade(EsameFacade esameFacade) {
		this.esameFacade = esameFacade;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	public Date getDataVisita() {
		return dataVisita;
	}
	
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	public Esame getEsame(){
		return this.esame;
	}
	
	public void setEsame(Esame esame){
		this.esame=esame;
	}
	
	public TipologiaEsame getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public String getId_utente() {
		return id_utente;
	}

	public void setId_utente(String id_utente) {
		this.id_utente = id_utente;
	}
	
	public UtenteFacade getUtenteFacade() {
		return this.utenteFacade;
	}

	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
	}

	public TipologiaEsameFacade getTipologiaEsamefacade() {
		return this.tipologiaEsamefacade;
	}

	public void setTipologiaEsamefacade(TipologiaEsameFacade tipologiaEsamefacade) {
		this.tipologiaEsamefacade = tipologiaEsamefacade;
	}

	public Utente getPaziente() {
		return this.paziente;
	}

	public void setPaziente(Utente paziente) {
		this.paziente = paziente;
	}

	public EsameController() {
	}

	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public String getNome_medico() {
		return this.nome_medico;
	}

	public void setNome_medico(String id_medico) {
		this.nome_medico = id_medico;
	}

//	public UtenteManager getSession() {
//		return session;
//	}
//
//	public void setSession(UtenteManager session) {
//		this.session = session;
//	}



}