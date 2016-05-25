package it.clinica.model;

import java.util.*;

public class Clinica {
	private Map<String, Medico> medici;
	private Map<String, TipologiaEsame> tipologieEsami;
	private Map<String, Paziente> pazienti;
	private Map<String, Amministratore> amministratori;
	
	
	
	public Map<String, Medico> getMedici() {
		return medici;
	}
	public void setMedici(Map<String, Medico> medici) {
		this.medici = medici;
	}
	public Map<String, TipologiaEsame> getTipologieEsami() {
		return tipologieEsami;
	}
	public void setTipologieEsami(Map<String, TipologiaEsame> tipologieEsami) {
		this.tipologieEsami = tipologieEsami;
	}
	public Map<String, Paziente> getPazienti() {
		return pazienti;
	}
	public void setPazienti(Map<String, Paziente> pazienti) {
		this.pazienti = pazienti;
	}
	public Map<String, Amministratore> getAmministratori() {
		return amministratori;
	}
	public void setAmministratori(Map<String, Amministratore> amministratori) {
		this.amministratori = amministratori;
	}
}
