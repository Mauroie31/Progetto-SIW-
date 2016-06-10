package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.PazienteDao;
import it.clinica.dao.UtenteDao;
import it.clinica.model.Esame;
import it.clinica.model.Paziente;

@Stateless(name="PazienteFacade")
public class PazienteFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public PazienteFacade(EntityManager em) {
		this.em = em;
	}
	
	public void inserisciPaziente(Paziente paziente) {
		this.em.getTransaction().begin();
		UtenteDao utenteDao = new UtenteDao(this.em);
		utenteDao.save(paziente);
		this.em.getTransaction().commit();
	}

	public Paziente findPaziente(Long id_paziente) {
		PazienteDao pazienteDao = new PazienteDao(this.em);
		this.em.getTransaction().begin();
		Paziente paziente = pazienteDao.findById(id_paziente);
		this.em.getTransaction().commit();
		return paziente;
	}

	public List<Paziente> findAllPazienti() {
		PazienteDao dao = new PazienteDao(this.em);
		this.em.getTransaction().begin();
		List<Paziente> result = dao.findAll();
		this.em.getTransaction().commit();
		return result;
	}

	public Paziente findPazienteByEsame(Long id_esame) {
		PazienteDao dao = new PazienteDao(this.em);
		this.em.getTransaction().begin();
		Paziente paziente = dao.findPazienteByEsame(id_esame);
		this.em.getTransaction().commit();
		return paziente;
	}

	public void setEsameToPaziente(Paziente paziente, Esame esame) {
		paziente.getEsami().add(esame);
		PazienteDao dao = new PazienteDao(this.em);
		this.em.getTransaction().begin();
		dao.update(paziente);
		this.em.getTransaction().commit();
	}

}
