package it.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinica.model.Prerequisito;

public class PrerequisitoDao extends AbstractDao<Prerequisito> {

	public PrerequisitoDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prerequisito findById(long id) {
		return this.getEntityManager().find(Prerequisito.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisito> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT p FROM Prerequisito");
		return query.getResultList();
	}


}
