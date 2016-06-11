package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.PrerequisitoDao;
import it.clinica.dao.RisultatoDao;
import it.clinica.model.Prerequisito;
import it.clinica.model.Risultato;

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
