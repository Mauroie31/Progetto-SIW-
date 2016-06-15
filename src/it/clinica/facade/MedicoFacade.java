package it.clinica.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.*;


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
	
	public Medico findMedicoByNome(String id_medico) {
		return this.em.find(Medico.class, id_medico);
	}
// Questa non serve
//	public List<Medico> findAllMedici() {
//		try {
//			return this.em.createNamedQuery("findAllMedici", Medico.class)
//					.getResultList();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
	
//	public Medico findMedicoByNome(String id_medico) {
//		try {
//			return this.em.createNamedQuery("findMedicoByNome", Medico.class)
//					.setParameter("nome_medico", id_medico).getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

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
//	@SuppressWarnings("unchecked")
	public List<Esame> findEsamiByMedico(String nome_medico){
		try{
			//List<Esame> esami= (List<Esame>) this.em.createQuery("SELECT e FROM Esame e where medico_id = ?1").setParameter(1, id_medico);
			return this.em.createNamedQuery("findEsamiByMedico", Esame.class).setParameter("nome_medico", nome_medico).getResultList();
		}catch (NoResultException e){
			System.out.println("la query findEsamiByMedico non funziona");
			return null;
		}
	}
	

}