package it.clinica.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "TipologieEsami")
@NamedQuery(name = "findAllTipologieEsami", query = "SELECT t FROM TipologieEsami t")
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @Column(nullable = false)
	private String nome;
	private String descrizione;
	private double costo;
	private Map<String, String> prerequisiti;
	@OneToMany(mappedBy="TipologieEsami")
	@JoinColumn(name="esami_id")
	private List<Esame> esami;
	private List<String> risultati;



	public List<String> getRisultati() {
		return risultati;
	}
	public void setRisultati(List<String> risultati) {
		this.risultati = risultati;
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
	public Map<String, String> getPrerequisiti() {
		return prerequisiti;
	}
	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
}
