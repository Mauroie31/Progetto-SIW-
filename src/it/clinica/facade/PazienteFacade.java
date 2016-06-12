package it.clinica.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.Esame;
import it.clinica.model.Paziente;


@Stateless
@EJB(name="ejb/pazienteFacade", beanInterface=PazienteFacade.class, beanName="pazienteFacade")
public class PazienteFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public PazienteFacade(EntityManager em) {
		this.em = em;
	}
	
	public PazienteFacade() {
		
	}
	
	public void inserisciPaziente(Paziente paziente) {
		this.em.persist(paziente);
	}

	public Paziente findPaziente(Long id_paziente) {
		return this.em.find(Paziente.class, id_paziente);
	}
	
	public Paziente createPaziente(String nome, Esame esame) {
		Paziente p = new Paziente();
		p.setNome(nome);
		p.addEsame(esame);
		this.em.persist(p);
		return p;
	}

	public List<Paziente> findAllPazienti() {
		try {
			return this.em.createNamedQuery("findAllPazienti", Paziente.class)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Paziente findPazienteByEsame(Long id_esame) {
		try {
			return this.em.createNamedQuery("findPazienteByEsame", Paziente.class)
					.setParameter("id_esame", id_esame).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void setEsameToPaziente(Paziente paziente, Esame esame) {
	     createPaziente(paziente.getNome(), esame);
	     this.em.merge(paziente);
	}

}
