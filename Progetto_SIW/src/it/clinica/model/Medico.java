package it.clinica.model;

import java.util.*;

public class Medico {
	private String codice, nome, cognome;
	private TipologiaEsame specializzazione;
	private Map<String, Esame> esami;
	
	
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public TipologiaEsame getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(TipologiaEsame specializzazione) {
		this.specializzazione = specializzazione;
	}
	public Map<String, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<String, Esame> esami) {
		this.esami = esami;
	}
}
