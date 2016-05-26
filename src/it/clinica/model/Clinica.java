package it.clinica.model;

import java.util.*;

public class Clinica {
	private Map<Long, Medico> medici;
	private Map<Long, TipologiaEsame> tipologieEsami;
	private Map<Long, Paziente> pazienti;
	private Map<Long, Amministratore> amministratori;
	
	
	
	public Map<Long, Medico> getMedici() {
		return medici;
	}
	public void setMedici(Map<Long, Medico> medici) {
		this.medici = medici;
	}
	public Map<Long, TipologiaEsame> getTipologieEsami() {
		return tipologieEsami;
	}
	public void setTipologieEsami(Map<Long, TipologiaEsame> tipologieEsami) {
		this.tipologieEsami = tipologieEsami;
	}
	public Map<Long, Paziente> getPazienti() {
		return pazienti;
	}
	public void setPazienti(Map<Long, Paziente> pazienti) {
		this.pazienti = pazienti;
	}
	public Map<Long, Amministratore> getAmministratori() {
		return amministratori;
	}
	public void setAmministratori(Map<Long, Amministratore> amministratori) {
		this.amministratori = amministratori;
	}
}
