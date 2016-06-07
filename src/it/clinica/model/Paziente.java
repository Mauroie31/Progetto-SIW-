package it.clinica.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pazienti")
public class Paziente extends Utente {
	private String indirizzo;
	private String ruolo;
	@OneToMany
	private Map<Long, Esame> esami;

	public Paziente() {
		this.ruolo = "user";
	}	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Map<Long, Esame> getEsami() {
		return esami;
	}

	public void setEsami(Map<Long, Esame> esami) {
		this.esami = esami;
	}
	
	public Esame getEsame(Long id) {
		return this.esami.get(id);
	}
	
	public Map<String, String> getRisultatiByEsame(Esame esame) {
		return esame.getRisultati();
		
	}
}
