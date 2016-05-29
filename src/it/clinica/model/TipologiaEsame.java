package it.clinica.model;

import java.util.*;

import javax.persistence.*;

public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Column(nullable = false)
	private String nome;
	private String descrizione;
	private double costo;
	private Set<String> indicatoriEsami;
	private Map<String, String> prerequisiti;
	@OneToMany
	private Map<Long, Esame> esami;



	public Map<Long, Esame> getEsami() {
		return esami;
	}
	public void setEsami(Map<Long, Esame> esami) {
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
	public Set<String> getIndicatoriEsami() {
		return indicatoriEsami;
	}
	public void setIndicatoriEsami(Set<String> indicatoriEsami) {
		this.indicatoriEsami = indicatoriEsami;
	}
	public Map<String, String> getPrerequisiti() {
		return prerequisiti;
	}
	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
}
