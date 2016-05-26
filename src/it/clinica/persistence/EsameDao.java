package it.clinica.persistence;

import it.clinica.model.*;

import java.util.*;

import javax.persistence.EntityManager;

public abstract class EsameDao extends AbstractDao<Esame> {

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
		return this.getEntityManager().createNamedQuery("Esame.findAll").getResultList();
	}
}
