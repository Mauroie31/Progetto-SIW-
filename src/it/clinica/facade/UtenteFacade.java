package it.clinica.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import it.clinica.model.Utente;

@Stateless
@EJB(name="ejb/utenteFacade", beanInterface=UtenteFacade.class, beanName="utenteFacade")
public class UtenteFacade {

	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public UtenteFacade(EntityManager em) {
		this.em = em;
	}
	public UtenteFacade() {
	}

	public List<Utente> findAllUtenti() {
		try {
			return this.em.createNamedQuery("findAllUtenti", Utente.class).getResultList();
		}
		catch (NoResultException e) {
			return null;
		}
	}
	
	public void inserisciUtente(Utente utente) {
		this.em.persist(utente);
	}

	public Utente findUtenteByEmail(String email) {
		return this.em.createNamedQuery("findUtenteByEmail", Utente.class)
				.setParameter("email_utente", email).getSingleResult();
	}
	
	public boolean esiste(String email) {
		return this.em.createNamedQuery("findUtenteByEmail", Utente.class)
				.setParameter("email_utente", email).getSingleResult() != null;
	}
	
	public Utente findUtenteById(Long id) {
		return this.em.createNamedQuery("findUtenteById", Utente.class)
				.setParameter("id_utente", id).getSingleResult();
	}

	public Utente autentica(String email, String password) {
		Utente utente = null;

		try {
			Utente temp;
			temp = findUtenteByEmail(email);
			if(temp != null && temp.getPassword()!= null && temp.getPassword().equals(password))
				utente=temp;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return utente;

	}
}
