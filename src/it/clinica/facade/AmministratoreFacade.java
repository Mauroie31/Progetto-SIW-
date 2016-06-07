package it.clinica.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.UtenteDao;
import it.clinica.model.Utente;
import it.clinica.persistence.EntityManagerFactorySingleton;

@Stateless(name="AmministratoreFacade")
public class AmministratoreFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public AmministratoreFacade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
	public void inserisciUtente(Utente utente) {
		this.em.getTransaction().begin();
		UtenteDao utenteDao = new UtenteDao(this.em);
		utenteDao.save(utente);
		this.em.getTransaction().commit();
	}

	public Utente findUtenteByEmail(String email) {
		UtenteDao utenteDao = new UtenteDao(this.em);
		this.em.getTransaction().begin();
		Utente utente = utenteDao.findUtenteByEmail(email);
		this.em.getTransaction().commit();
		return utente;

	}

}