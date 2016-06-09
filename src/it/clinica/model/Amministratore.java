package it.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Amministratori")
@NamedQuery(name = "findAllAmministratori", query = "SELECT a FROM Amministratori a")
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
