package it.clinica.dao;

import java.util.*;
import javax.persistence.*;

public abstract class AbstractDao<T> {
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;


	public AbstractDao(EntityManager em) {
		this.em = em;
	}

	public void save(T entity) {
		em.persist(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public abstract T findById(long id);

	public abstract List<T> findAll();
}