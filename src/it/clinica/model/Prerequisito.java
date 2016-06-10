package it.clinica.model;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "Prerequisito")
@NamedQuery(name = "findAllPrerequisiti", query = "SELECT p FROM Prerequisito p")
public class Prerequisito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public List<TipologiaEsame> getTipologieEsamePerQuestoPrerequisito() {
		return tipologieEsamePerQuestoPrerequisito;
	}
	public void setTipologieEsamePerQuestoPrerequisito(
			List<TipologiaEsame> tipologieEsamePerQuestoPrerequisito) {
		this.tipologieEsamePerQuestoPrerequisito = tipologieEsamePerQuestoPrerequisito;
	}	
}
