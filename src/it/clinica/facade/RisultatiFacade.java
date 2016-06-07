package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.RisultatiDao;
import it.clinica.model.Risultati;
import it.clinica.persistence.EntityManagerFactorySingleton;

@Stateless(name="RisultatiFacade")
public class RisultatiFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public RisultatiFacade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
	
	public void inserisciRisultati(Risultati risultati) {
		this.em.getTransaction().begin();
		RisultatiDao dao = new RisultatiDao(this.em);
		dao.save(risultati);
		this.em.getTransaction().commit();
	}
	
	
	public List<Risultati> getRisultatiByEsame(Long id_esame) {
		RisultatiDao dao = new RisultatiDao(this.em);
		this.em.getTransaction().begin();
		List<Risultati> risultati = dao.findRisultatiByEsame(id_esame);
		this.em.getTransaction().commit();
		return risultati;
	}

}
