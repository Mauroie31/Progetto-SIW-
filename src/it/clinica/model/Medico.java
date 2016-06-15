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
	@NamedQuery(name = "findEsamiByMedico", 
	query = "SELECT e FROM Esame e where e.medico_nome = :id_medico"),
	@NamedQuery(name = "findMediciByTipologiaEsame", 
	query = "SELECT m FROM Medico m JOIN TipologiaEsame t where t.id = :id_tipologiaEsame"),
	@NamedQuery(name = "findMedicoById", 
	query = "SELECT m FROM Medico m where m.id = :id_medico")
})

public class Medico {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	@Column(nullable = false)
	@Id
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String specializzazione;
	@OneToMany(mappedBy="medico", fetch=FetchType.EAGER)
	private List<Esame> esami;
	
	public Medico() {
		
	}

//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
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
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}
}