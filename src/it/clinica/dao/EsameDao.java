package it.clinica.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinica.model.Esame;

public class EsameDao extends AbstractDao<Esame> {

	public EsameDao(EntityManager em) {
		super(em);
	}

	@Override
	public Esame findById(long id) {
		return this.getEntityManager().find(Esame.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Esame> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT e FROM Esami e");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Esame> findEsamiByIdPaziente(Long id_paziente) {
		Query query = this.getEntityManager().createQuery("SELECT e FROM Esami e JOIN Utente u where u.id = :id_paziente");
		query.setParameter("id_paziente", id_paziente);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Esame> findEsamibyIdMedico (Long id_medico) {
		Query query = this.getEntityManager().createQuery("SELECT e FROM Esami e JOIN Medico m where m.id = :id_medico");
		query.setParameter("id_medico", id_medico);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Esame> findEsamiByDataPrenotazione(Date dataPrenotazione) {
		Query query = this.getEntityManager().createQuery("SELECT e FROM Esami e WHERE e.dataprenotazione = :dataPrenotazione");
		query.setParameter("dataPrenotazione", dataPrenotazione);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Esame> findEsamyBydataVisita(Date dataVisita) {
		Query query = this.getEntityManager().createQuery("SELECT e FROM Esami e WHERE e.dataprenotazione = :dataVisita");
		query.setParameter("dataVisita", dataVisita);
		return query.getResultList();
	}
	
	

	
}
