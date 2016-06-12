package it.clinica.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.Medico;

@Stateless
@EJB(name="ejb/medicoFacade", beanInterface=MedicoFacade.class, beanName="medicoFacade")
public class MedicoFacade {
	
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public MedicoFacade(EntityManager em) {
		this.em = em;
	}
	
	public MedicoFacade() {
		
	}
	
	public Medico findMedico(Long id_medico) {
		return this.em.find(Medico.class, id_medico);
	}

	public List<Medico> findAllMedici() {
		try {
			return this.em.createNamedQuery("findAllMedici", Medico.class)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Medico findMedicoByEsame(Long id_esame) {
		try {
			return this.em.createNamedQuery("findmedicoByEsame", Medico.class)
					.setParameter("id_esame", id_esame).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Medico> findMediciByTipologiaEsame(Long id_tipologiaEsame) {
		try {
			return this.em.createNamedQuery("findMediciByTipologiaEsame", Medico.class)
					.setParameter("id_tipologiaEsame", id_tipologiaEsame).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
