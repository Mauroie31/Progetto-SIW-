package it.clinica.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Esame")
@NamedQueries({
	@NamedQuery(name = "findAllEsami", 
			query = "SELECT e FROM Esame e"),
	@NamedQuery(name = "findEsamiByPaziente", 
          	query="SELECT e FROM Esame e JOIN Utente u where u.id = :id_paziente"),
	/*@NamedQuery(name = "findEsamiByMedico",
	        query ="SELECT e FROM Esame e JOIN Medicos m where m.id = :id_medico"),*/
	@NamedQuery(name = "findEsamiByMedico", query = "SELECT e FROM Esame e where nome_medico = :id_medico"),
	@NamedQuery(name = "findEsamiByDataPrenotazione",
	        query = "SELECT e FROM Esame e WHERE e.dataprenotazione = :dataPrenotazione"),
	@NamedQuery(name = "findEsamiByDataVisita",
	        query = "SELECT e FROM Esame e WHERE e.dataprenotazione = :dataVisita"),
	@NamedQuery(name = "findEsamiByTipologiaEsame",
			query = "SELECT e FROM Esame e JOIN TipologiaEsame t WHERE t.id = :id_tipologiaEsame")
})
	public class Esame  {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		@ManyToMany
		private List<Risultato> risultati;
		
		@Temporal(TemporalType.DATE)
		private Date dataPrenotazione;
		
		@Temporal(TemporalType.DATE)
		private Date dataVisita;
		
		@ManyToOne
		private TipologiaEsame tipologiaEsame;
		
		@ManyToOne
		private Utente utente;
		
		@ManyToOne
		private Medico medico;
		
		public Esame() {
			
		}
		
		public Utente getUtente() {
			return utente;
		}


		public void setUtente(Utente utente) {
			this.utente = utente;
		}


		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		//TODO ToString
		/*
	public void setNome() {
		this.nome = this.tipologiaEsame.getNome() + "di" + this.paziente.getNome() + this.paziente.getCognome();
	}
		 */

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
		
		public Medico getMedico() {
			return medico;
		}
		public void setMedico(Medico medico) {
			this.medico = medico;
		}

	}