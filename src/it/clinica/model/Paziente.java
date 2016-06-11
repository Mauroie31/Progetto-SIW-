package it.clinica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pazienti")
@NamedQuery(name = "findAllPazienti", query = "SELECT p FROM Pazienti p")
public class Paziente extends Utente  {
	private String indirizzo;
	@Column(nullable = false)
	private String ruolo;
	@OneToMany(mappedBy="Pazienti")
	@JoinColumn(name = "esami_id")
	private List<Esame> esami;

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
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
}
