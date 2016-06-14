package it.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Utente")
@NamedQuery(name = "findAll", query = "SELECT a FROM Amministratore a")
public class Amministratore extends Utente {
	@Column(nullable = false)
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
