package it.clinica.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.EsameFacade;
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
	private Long id;
	private String nome;
	private String descrizione;
	private List<Risultati> risultati;
	private Date dataPrenotazione;
	private Date dataVisita;
	private TipologiaEsame tipologiaEsame;
	private Paziente paziente;
	private Medico medico;
	
	
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
		return tipologiaEsame;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
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
	
	

}
