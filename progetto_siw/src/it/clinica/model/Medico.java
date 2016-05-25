package it.clinica.model;

import java.util.*;

public class Medico {
	private Long id;
	private String nome, cognome;
	private TipologiaEsame specializzazione;
	private Map<Long, Esame> esami;



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
	public Map<Long, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<Long, Esame> esami) {
		this.esami = esami;
	}
}
