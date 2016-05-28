package it.clinica.dao;

import it.clinica.model.*;
import java.util.*;
import javax.persistence.EntityManager;

public class TipologiaEsameDao extends AbstractDao<TipologiaEsame> {

	public TipologiaEsameDao(EntityManager em) {
		super(em);
	}

	@Override
	public TipologiaEsame findById(long id) {
		return this.getEntityManager().find(TipologiaEsame.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipologiaEsame> findAll() {
		return this.getEntityManager().createNamedQuery("TipologiaEsame.findAll").getResultList();
	}

}
