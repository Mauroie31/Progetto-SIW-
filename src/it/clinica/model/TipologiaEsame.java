package it.clinica.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "TipologieEsami")
@NamedQueries({
	@NamedQuery(name = "findAllTipologieEsami", 
	query = "SELECT t FROM TipologieEsami t"),
	@NamedQuery(name = "findTipologiaEsameByEsame",
    query = "SELECT t FROM TipologieEsami t JOIN Esami e WHERE e.id = :id_esame")
})

public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @Column(nullable = false)
	private String nome;
	private String descrizione;
	private double costo;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	private List<Prerequisito> prerequisiti;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	private List<Risultato> risultati;
	
	@OneToMany
	private List<Esame> esami;
	
	public TipologiaEsame() {}
	
	public TipologiaEsame(String nome, String descrizione, double costo, List<Prerequisito> p) {
		this.nome=nome;
		this.descrizione=descrizione;
		this.costo=costo;
		this.prerequisiti=p;
	}


	public List<Risultato> getRisultatiProposti() {
		return this.risultati;
	}
	public void setRisultatiProposti(List<Risultato> risultatiProposti) {
		this.risultati = risultatiProposti;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
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
	
	
	public List<Risultato> getRisultati() {
		return risultati;
	}


	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}


	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Prerequisito> getPrerequisiti() {
		return this.prerequisiti;
	}
	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
}
