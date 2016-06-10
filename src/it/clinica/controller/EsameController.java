package it.clinica.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.faces.bean.ManagedProperty;
import it.clinica.facade.EsameFacade;
import it.clinica.facade.PazienteFacade;
import it.clinica.facade.TipologiaEsameFacade;
import it.clinica.model.Esame;
import it.clinica.model.Medico;
import it.clinica.model.Paziente;
import it.clinica.model.Risultati;
import it.clinica.model.TipologiaEsame;

@ManagedBean
@RequestScoped
@EJB(name = "esameFacade", beanInterface = EsameFacade.class) 
public class EsameController {
	@EJB(name = "esameFacade")
	private EsameFacade esameFacade;
	@EJB(name = "pazienteFacade")
	private PazienteFacade pazienteFacade;
	@EJB(name = "tipolgiaEsameFacade")
	private TipologiaEsameFacade tipologiaEsamefacade;
	
	private Long id;// da togliere
	private String nome;
	private String descrizione;
	private List<Risultati> risultati;
	private Date dataPrenotazione;
	private Date dataVisita;
	private TipologiaEsame tipologia;
	private Paziente paziente;
	private Medico medico;
	private Esame esameDaCreare;

	
	@ManagedProperty(value = "#{utenteManager}")
	private UtenteManager session;

	//Caso d'uso UC2
	public String creaEsame() {
		this.esameDaCreare = this.esameFacade.createEsame(id, nome, descrizione, risultati, dataPrenotazione, dataVisita, tipologia, paziente, medico);
		this.esameFacade.inserisciEsame(esameDaCreare);
        return "/portaleAdmin/creaEsame.jsp";
	}
	
	public String associaTipologiaEsameAdEsameDaCreare(Long id_tipologia) {
		TipologiaEsame tipologia = this.tipologiaEsamefacade.findTipologiaEsame(id_tipologia);
		this.esameFacade.associaTipologiaEsameAdEsame(tipologia, esameDaCreare);
		return "/portaleAdmin/inserisciTipologiaEsame.jsp";
	}
	
	public String associaPazienteAdEsame(Long id_Paziente, Esame e) {
		Paziente paziente = this.pazienteFacade.findPaziente(id_Paziente);
		this.esameFacade.associaPazienteAdEsame(paziente, e);
		return "/portaleAdmin/associaPaziente.jsp";
	}
	
	public String registraEsame() {
		Date dataPrenotazione = new Date();
		this.esameFacade.impostaDataPrenotazioneAdEsame(esameDaCreare, (java.sql.Date) dataPrenotazione);
        //devo fare l'update dell'esameDaCreare
		this.esameFacade.UpdateEsame(esameDaCreare);
		return "/portaleAdmin/esameRegistrato.jsp";
	
	}
	//fine caso d'uso UC2
	
	
	


	//Getters and Setters
	public EsameFacade getEsameFacade() {
		return esameFacade;
	}
	public void setEsameFacade(EsameFacade esameFacade) {
		this.esameFacade = esameFacade;
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
	public List<Risultati> getRisultati() {
		return risultati;
	}
	public void setRisultati(List<Risultati> risultati) {
		this.risultati = risultati;
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
	public TipologiaEsame getTipologiaEsame() {
		return tipologia;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologia = tipologiaEsame;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public UtenteManager getSession() {
		return session;
	}

	public void setSession(UtenteManager session) {
		this.session = session;
	}



}
