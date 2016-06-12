package it.clinica.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.model.Utente;

@Stateless
@EJB(name="ejb/amministratoreFacade", beanInterface=AmministratoreFacade.class, beanName="amministratoreFacade")
public class AmministratoreFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public AmministratoreFacade(EntityManager em) {
		this.em =em;
	}
	
	public AmministratoreFacade() {
		
	}
	
	public void inserisciUtente(Utente utente) {
		this.em.persist(utente);
	}

	public Utente findUtenteByEmail(String email) {
		return this.em.createNamedQuery("findUtenteByEmail", Utente.class).setParameter("email_utente", email).getSingleResult();

	}

}
