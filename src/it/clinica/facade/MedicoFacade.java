package it.clinica.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.MedicoDao;
import it.clinica.model.Medico;
import it.clinica.persistence.EntityManagerFactorySingleton;

@Stateless(name="medicoFacade")
public class MedicoFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public MedicoFacade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}
	
	
	
	public void inserisciMedico(Medico medico) {
		this.em.getTransaction().begin();
		MedicoDao medicoDao = new MedicoDao(this.em);
		medicoDao.save(medico);
		this.em.getTransaction().commit();
	}

	public Medico findMedico(Long id_medico) {
		MedicoDao medicoDao = new MedicoDao(this.em);
		this.em.getTransaction().begin();
		Medico medico = medicoDao.findById(id_medico);
		this.em.getTransaction().commit();
		return medico;
	}

	public List<Medico> findAllMedici() {
		MedicoDao dao = new MedicoDao(this.em);
		this.em.getTransaction().begin();
		List<Medico> result = dao.findAll();
		this.em.getTransaction().commit();
		return result;
	}

	public Medico findMedicoByEsame(Long id_esame) {
		MedicoDao dao = new MedicoDao(this.em);
		this.em.getTransaction().begin();
		Medico medico = dao.findMedicoByEsame(id_esame);
		this.em.getTransaction().commit();
		return medico;
	}

	public List<Medico> findMediciByTipologiaEsame(Long id_esame) {
		MedicoDao dao = new MedicoDao(this.em);
		this.em.getTransaction().begin();
		List<Medico> medici = dao.findMediciByTipologiaEsame(id_esame);
		this.em.getTransaction().commit();
		return medici;
	}

}
