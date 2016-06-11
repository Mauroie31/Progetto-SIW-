package it.clinica.model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Risultati")
@NamedQuery(name = "findAllRisultati", query = "SELECT r FROM Risultati r")
public class Risultato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@ManyToMany (mappedBy="risultati")
	private List<TipologiaEsame> tipologieEsami;

	public Risultato(){}

	public Risultato( String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long codice) {
		this.id = codice;
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


}
