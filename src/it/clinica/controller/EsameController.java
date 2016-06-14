package it.clinica.controller;

import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import it.clinica.facade.EsameFacade;
import it.clinica.facade.TipologiaEsameFacade;
//import it.clinica.facade.UtenteFacade;
import it.clinica.model.Esame;
//import it.clinica.model.Medico;
import it.clinica.model.TipologiaEsame;


@ManagedBean(name="esameController")
@SessionScoped
public class EsameController {
	
	@EJB(name = "esameFacade")
	private EsameFacade esameFacade;
//	@EJB(name = "utenteFacade")
//	private UtenteFacade utenteFacade;
	@EJB(name = "tipolgiaEsameFacade")
	private TipologiaEsameFacade tipologiaEsamefacade;

	public EsameController() {
	}

//	private List<Risultato> risultati; //TODO
	
	
	private Date dataPrenotazione;
	private Date dataVisita;
	
	private TipologiaEsame tipologia;
	private String id_utente;
	
	

//	private Medico medico; //rigiarda il caso d'uso 5
	private Esame esame;


//	@ManagedProperty(value = "#{utenteManager}")
//	private UtenteManager session;

	//Caso d'uso UC2
	public String creaEsame() {
		this.esame=this.esameFacade.createEsame(this.dataVisita);
		return "/portaleAdmin/dettagliPrenotazioneEsame.jsp";
	}
	
// questo metodo è sostituito da setTipologiaPerPrenotazioneEsame
//	public String associaTipologiaEsameAdEsameDaCreare(Long id_tipologia) {
//		TipologiaEsame tipologia = this.tipologiaEsamefacade.findTipologiaEsame(id_tipologia);
//		this.esameFacade.associaTipologiaEsameAdEsame(tipologia, esameDaCreare);
//		return "/portaleAdmin/inserisciTipologiaEsame.jsp";
//	}

//	public String associaPazienteAdEsame() {
//		Utente paziente = this.utenteFacade.findUtente(this.id_utente);
//		this.esameFacade.associaPazienteAdEsame(paziente, this.esame);
//		return "/portaleAdmin/FineInserimentoPrenotazioneEsame.jsp";
//	}
	
	public String setTipologiaPerPrenotazioneEsame(TipologiaEsame tipologia){
		this.esameFacade.associaTipologiaEsameAdEsame(tipologia);
		return "/portaleAdmin/dettagliPrenotazioneEsame.jsp";
	}
	
	// per il momento serve solo a vedere se riesco a mettere la tipologia ad una prenotazione esame
	public String goToPaginaFineInserimentoPrenotazioneEsame(){
		return "/portaleAdmin/fineInserimentoPrenotazioneEsame.jsp";
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
	

//	public Paziente getPaziente() {
//		return paziente;
//	}
//	public void setPaziente(Paziente paziente) {
//		this.paziente = paziente;
//	}
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

	//Riguarda il caso d'uso 5
	/*public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}*/

//	public UtenteManager getSession() {
//		return session;
//	}
//
//	public void setSession(UtenteManager session) {
//		this.session = session;
//	}



}
