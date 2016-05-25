package it.clinica.model;

import java.util.Map;

public class Paziente extends Utente {
	private String indirizzo, email, ruolo;
	private Map<String, Esame> esamiSvolti;

	public Paziente() {
		this.ruolo = "user";
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Map<String, Esame> getEsamiSvolti() {
		return esamiSvolti;
	}

	public void setEsamiSvolti(Map<String, Esame> esamiSvolti) {
		this.esamiSvolti = esamiSvolti;
	}





}
