package it.clinica.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.TipologiaEsame;

@Stateless
@EJB(name="ejb/tipologiaEsameFacade", beanInterface=TipologiaEsameFacade.class, beanName="tipologiaEsameFacade")
public class TipologiaEsameFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public TipologiaEsameFacade(EntityManager em) {
		this.em = em;
	}	
	
	public TipologiaEsameFacade() {
		
	}
	
	public void inserisciTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.em.persist(tipologiaEsame);
	}

	public TipologiaEsame findTipologiaEsame(Long id_tipologiaEsame) {
		return this.em.find(TipologiaEsame.class, id_tipologiaEsame);
	}

	public List<TipologiaEsame> findAllTipologieEsami() {
		try {
			return this.em.createNamedQuery("findAllTipologieEsami", TipologiaEsame.class)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public TipologiaEsame findTipologiaEsameByEsame(Long id_esame) {
		try {
			return this.em.createNamedQuery("findTipologiaEsameByEsame", TipologiaEsame.class)
					.setParameter("id_esame", id_esame).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
