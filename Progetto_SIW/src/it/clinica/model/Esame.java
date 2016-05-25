package it.clinica.model;

import java.util.*;

public class Esame {
	private String codice, nome, descrizione;
	private TipologiaEsame tipologia;
	private Map<String,String> risultati;
	private Date dataPrenotazione, dataVisita;
	private Paziente paziente;
	private Medico medico;
	
	
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
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
	public Tipologia getTipologia() {
		return tipologia;
	}
	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}
	public Map<String, String> getRisultati() {
		return risultati;
	}
	public void setRisultati(Map<String, String> risultati) {
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
