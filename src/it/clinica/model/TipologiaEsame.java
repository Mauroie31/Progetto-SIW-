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
	@ManyToMany
	private List<Prerequisito> prerequisiti;
	@ManyToMany
	private List<RisultatoProposto> risultatiProposti;
//	@OneToMany(mappedBy="TipologieEsami")
//	@JoinColumn(name="esami_id")
//	private List<Esame> esami;
	
	public TipologiaEsame() {}


	public List<RisultatoProposto> getRisultatiProposti() {
		return this.risultatiProposti;
	}
	public void setRisultatiProposti(List<RisultatoProposto> risultatiProposti) {
		this.risultatiProposti = risultatiProposti;
	}
//	public List<Esame> getEsami() {
//		return esami;
//	}
//	public void setEsami(List<Esame> esami) {
//		this.esami = esami;
//	}
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
	public List<Prerequisito> getPrerequisiti() {
		return this.prerequisiti;
	}
	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
}
