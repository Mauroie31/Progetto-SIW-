package it.clinica.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Esami")
@NamedQuery(name = "findAllEsami", query = "SELECT e FROM Esami e")
public class Esame {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @Column(nullable = false)
	private String nome;
	private String descrizione;
	private Map<String, String> risultati;
	@Temporal(TemporalType.DATE)
	private Date dataPrenotazione;
	@Temporal(TemporalType.DATE)
	private Date dataVisita;
	@ManyToOne
	private TipologiaEsame tipologiaEsame;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne
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
	public void setNome() {
		this.nome = this.tipologiaEsame.getNome() + "di" + this.paziente.getNome() + this.paziente.getCognome();
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Map<String, String> getRisultati() {
		return this.risultati;
	}
	public void setRisultati(Map<String, String> risultati) {		
		this.risultati = risultati;
	}
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
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
