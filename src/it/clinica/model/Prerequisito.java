package it.clinica.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.NamedQuery;



@Entity
//query definita staticamente
@NamedQuery(name = "trovaTuttiPrerequisiti", query = "SELECT p FROM Prerequisito p")
public class Prerequisito {


	@Id
	private String nome;
	@Column(nullable=false)
	private String descrizione;
	
	@ManyToMany(mappedBy="prerequisiti")
	private List<TipologiaEsame> tipologieEsamePerQuestoPrerequisito;
	
	public Prerequisito(){}
	
	public Prerequisito(String nome, String cognome) {
		this.nome = nome;
		this.descrizione = cognome;
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
