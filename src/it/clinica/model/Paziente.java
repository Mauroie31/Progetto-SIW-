package it.clinica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utente")
@NamedQueries({
	@NamedQuery(name = "findAll", 
	query = "SELECT p FROM Paziente p"),
	@NamedQuery(name = "findPazienteByEsame", 
	query = "SELECT p FROM Paziente p JOIN Esame e where e.id = :id_esame")

})
public class Paziente extends Utente  {
	private String indirizzo;
	@Column(nullable = false)
	private String ruolo;
	@OneToMany
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
	
	public void addEsame(Esame esame) {
		this.esami.add(esame);
	}
}
