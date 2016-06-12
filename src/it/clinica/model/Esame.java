package it.clinica.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Esami")
@NamedQueries({
	@NamedQuery(name = "findAllEsami", 
			query = "SELECT e FROM Esami e"),
	@NamedQuery(name = "findEsamiByPaziente", 
          	query="SELECT e FROM Esami e JOIN Utente u where u.id = :id_paziente"),
	@NamedQuery(name = "findEsamiByMedico",
	        query ="SELECT e FROM Esami e JOIN Medico m where m.id = :id_medico"),
	@NamedQuery(name = "findEsamiByDataPrenotazione",
	        query = "SELECT e FROM Esami e WHERE e.dataprenotazione = :dataPrenotazione"),
	@NamedQuery(name = "findEsamiByDataVisita",
	        query = "SELECT e FROM Esami e WHERE e.dataprenotazione = :dataVisita"),
	@NamedQuery(name = "findEsamiByTipologiaEsame",
			query = "SELECT e FROM Esami e JOIN TipologiaEsame t WHERE t.id = :id_tipologiaEsame")
})

	public class Esame {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		@Column(nullable = false)
		private String nome;
		private String descrizione;
		private List<Risultato> risultati;
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
		
		public Esame() {
			
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
			this.nome=nome;
		}
		//TODO ToString
		/*
	public void setNome() {
		this.nome = this.tipologiaEsame.getNome() + "di" + this.paziente.getNome() + this.paziente.getCognome();
	}
		 */
		public String getDescrizione() {
			return descrizione;
		}
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		public List<Risultato> getRisultati() {
			return risultati;
		}
		public void setRisultati(List<Risultato> risultati) {
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
