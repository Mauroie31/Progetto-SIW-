package it.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinica.model.Risultati;

public class RisultatiDao extends AbstractDao<Risultati> {

	public RisultatiDao(EntityManager em) {
		super(em);
	}

	@Override
	public Risultati findById(long id) {
		return this.getEntityManager().find(Risultati.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Risultati> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT r FROM Risultati r");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Risultati> findRisultatiByEsame(Long id_esame) {
		Query query = this.getEntityManager().createQuery("SELECT r FROM Risultati JOIN Esami e WHERE e.id = :id_esame");
		query.setParameter("id_esame", id_esame);
		return query.getResultList();
	}

}
