package it.clinica.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "Prerequisiti")
@NamedQuery(name = "findAllPrerequisiti", query = "SELECT p FROM Prerequisito p")
public class Prerequisito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	private String descrizione;
	@ManyToMany
	private List<TipologiaEsame> tipologieEsami;


	public Prerequisito(){
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<TipologiaEsame> getTipologieEsami() {
		return tipologieEsami;
	}


	public void setTipologieEsami(List<TipologiaEsame> tipologieEsami) {
		this.tipologieEsami = tipologieEsami;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
