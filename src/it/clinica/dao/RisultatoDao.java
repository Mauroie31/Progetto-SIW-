package it.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinica.model.Risultato;

public class RisultatoDao extends AbstractDao<Risultato> {

	public RisultatoDao(EntityManager em) {
		super(em);
	}

	@Override
	public Risultato findById(long id) {
		return this.getEntityManager().find(Risultato.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Risultato> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT r FROM Risultati r");
		return query.getResultList();
	}
	

}
