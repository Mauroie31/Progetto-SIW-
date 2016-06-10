package it.clinica.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.clinica.dao.UtenteDao;
import it.clinica.model.Utente;

@Stateless(name="utenteFacade")
public class UtenteFacade {

	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public UtenteFacade(EntityManager em) {
		this.em = em;
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
	
	public Utente autentica(String email, String password) {
		Utente utente = null;
		UtenteDao utenteDao = new UtenteDao(this.em);

		try {
			Utente temp;
			temp = utenteDao.findUtenteByEmail(email);
			if(temp != null && temp.getPassword()!= null && temp.getPassword().equals(password))
				utente=temp;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return utente;

	}
}
