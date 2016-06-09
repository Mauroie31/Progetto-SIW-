package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.TipologiaEsameDao;
import it.clinica.model.TipologiaEsame;
import it.clinica.persistence.EntityManagerFactorySingleton;

@Stateless(name="TipologiaEsameFacade")
public class TipologiaEsameFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public TipologiaEsameFacade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
	
	
	
	public void inserisciTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.em.getTransaction().begin();
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(this.em);
		tipologiaEsameDao.save(tipologiaEsame);
		this.em.getTransaction().commit();
	}

	public TipologiaEsame findTipologiaEsame(Long id_tipologiaEsame) {
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		TipologiaEsame tipologiaEsame = tipologiaEsameDao.findById(id_tipologiaEsame);
		this.em.getTransaction().commit();
		return tipologiaEsame;
	}

	public List<TipologiaEsame> findAllTipologieEsami() {
		TipologiaEsameDao dao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		List<TipologiaEsame> result = dao.findAll();
		this.em.getTransaction().commit();
		return result;
	}

	public TipologiaEsame findTipologiaEsameByEsame(Long id_esame) {
		TipologiaEsameDao dao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		TipologiaEsame tipologiaEsame = dao.findTipologiaEsameByEsame(id_esame);
		this.em.getTransaction().commit();
		return tipologiaEsame;
	}

}
