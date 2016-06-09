package it.clinica.dao;

import it.clinica.model.Paziente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PazienteDao extends AbstractDao<Paziente> {

	public PazienteDao(EntityManager em) {
		super(em);
	}

	@Override
	public Paziente findById(long id) {
		return this.getEntityManager().find(Paziente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paziente> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT p FROM Pazienti p");
		return query.getResultList();
	}

	public Paziente findPazienteByEsame(Long id_esame) {
		Query query = this.getEntityManager().createQuery("SELECT p FROM Pazienti p JOIN Esami e where e.id = :id_esame");
		query.setParameter("id_esame", id_esame);
		return (Paziente) query.getSingleResult();		
	}
}
