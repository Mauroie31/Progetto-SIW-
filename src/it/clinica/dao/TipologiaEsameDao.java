package it.clinica.dao;

import java.util.List;

import javax.persistence.*;

import it.clinica.model.TipologiaEsame;

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
		Query query = this.getEntityManager().createQuery("SELECT t FROM TipologieEsami t");
		return query.getResultList();
	}

	public TipologiaEsame findTipologiaEsameByEsame(Long id_esame) {
		Query query = this.getEntityManager().createQuery("SELECT t FROM TipologieEsami t JOIN Esami e WHERE e.id = :id_esame");
		query.setParameter("id_esame", id_esame);
		return (TipologiaEsame) query.getSingleResult();
	}
}