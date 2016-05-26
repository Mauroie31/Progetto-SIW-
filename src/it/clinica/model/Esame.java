package it.clinica.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Esami")
public class Esame {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descrizione;
	private Map<String, String> risultati;
	private Date dataPrenotazione;
	private Date dataVisita;
	@OneToOne
	private TipologiaEsame tipologiaEsame;
	@OneToOne
	private Paziente paziente;
	@OneToOne
	private Medico medico;



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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipologiaEsame getTipologia() {
		return tipologiaEsame;
	}
	public void setTipologia(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	public Map<String, String> getRisultati() {
		return risultati;
	}
	public void setRisultati(Map<String, String> risultati) {
		this.risultati = risultati;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
