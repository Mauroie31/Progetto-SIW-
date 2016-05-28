package it.clinica.dao;

import it.clinica.model.Amministratore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AmministratoreDao extends AbstractDao<Amministratore> {

	public AmministratoreDao(EntityManager em) {
		super(em);
	}

	@Override
	public Amministratore findById(long id) {
		return this.getEntityManager().find(Amministratore.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Amministratore> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT a FROM Amministratori a");
		return query.getResultList();
	}
}