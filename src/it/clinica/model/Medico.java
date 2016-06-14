package it.clinica.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "Medico")
@NamedQueries({
	@NamedQuery(name = "findAllMedici", 
	query = "SELECT m FROM Medico m"),
	@NamedQuery(name = "findMedicoByEsame", 
	query = "SELECT m FROM Medico m JOIN Esame e where e.id = :id_esame"),
	@NamedQuery(name = "findMediciByTipologiaEsame", 
	query = "SELECT m FROM Medico m JOIN TipologiaEsame t where t.id = :id_tipologiaEsame"),
})
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@ManyToOne
	private TipologiaEsame specializzazione;
	@OneToMany
	private List<Esame> esami;
	
	public Medico() {
		
	}

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
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
}
