package it.clinica.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Amministratori")
public class Amministratore extends Utente {
	private String ruolo;

	public Amministratore() {
		this.ruolo = "admin";
	}



	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
