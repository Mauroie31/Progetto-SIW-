package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.*;
import it.clinica.model.*;

@Stateless(name="risultatoFacade")
public class RisultatoFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;
	
	public RisultatoFacade(EntityManager em) {
		this.em = em;
	}

	public List<Risultato> findAllRisultati() {
		RisultatoDao dao = new RisultatoDao(this.em);
		this.em.getTransaction().begin();
		List<Risultato> lista = dao.findAll();
		this.em.getTransaction().commit();
		return lista;
	}

}
