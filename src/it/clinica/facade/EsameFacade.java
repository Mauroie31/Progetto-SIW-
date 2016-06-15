package it.clinica.facade;

import java.util.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.Esame;
import it.clinica.model.Medico;
import it.clinica.model.TipologiaEsame;
import it.clinica.model.Utente;

@Stateless
@EJB(name="ejb/esameFacade", beanInterface=EsameFacade.class, beanName="esameFacade")
public class EsameFacade {
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;
	private Esame esame;

	public EsameFacade(EntityManager em) {
		this.em = em;
		
	}
	
	public EsameFacade() {
		
	}
	//non credo che serva
	public Esame UpdateEsame(Esame esame) {
		return this.em.merge(esame);
	}
	
	public Esame createEsame(Date dataVisita) {
		this.esame = new Esame();
		this.esame.setDataVisita(dataVisita);
		Date dataPrenotazione= new Date();
		this.esame.setDataPrenotazione(dataPrenotazione);
		this.em.persist(this.esame);
		return this.esame;
	}
	

	public Esame findEsame(Long id_esame) {
		try {
			return this.em.createNamedQuery("findEsame", Esame.class)
					.setParameter("id_esame", id_esame).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Esame> findAllEsami() {
		try {
			return this.em.createNamedQuery("findAllEsami", Esame.class)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
//	public List<Esame> findEsamiByMedico(Long id_medico){
//		try{
//			return this.em.createNamedQuery("findEsamiByMedico", Esame.class).setParameter("id_medico", id_medico).getResultList();
//		}catch (NoResultException e){
//			System.out.println("la query findEsamiByMedico non funziona");
//			return null;
//		}
//	}

//	public List<Esame> findEsamiByPaziente(Long id_paziente) {
//		try {
//			return this.em.createNamedQuery("findEsamiByPaziente", Esame.class)
//					.setParameter("id_paziente", id_paziente).getResultList();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

//	public List<Esame> findEsamiByMedico(Long id_medico) {
//		try {
//			return this.em.createNamedQuery("findEsamiByMedico", Esame.class)
//					.setParameter("id_medico", id_medico).getResultList();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

//	public List<Esame> findEsamiByDataPrenotazione(Date datap) {
//		try {
//			return this.em.createNamedQuery("findEsamiByDataPrenotazione", Esame.class)
//					.setParameter("dataPrenotazione", datap).getResultList();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

//	public List<Esame> findEsamiByDataVisita(Date data) {
//		try {
//			return this.em.createNamedQuery("findEsamiByDataVisita", Esame.class)
//					.setParameter("dataVisita", data).getResultList();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}

	//non so se serve
	public List<Esame> findEsamiByTipologia(Long id_tipologia) {
		try {
			return this.em.createNamedQuery("findEsamiByTipologia", Esame.class)
					.setParameter("id_tipologiaEsame", id_tipologia).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void associaPazienteAdEsame(Utente paziente, Esame esame) {
		this.esame.setUtente(paziente);
		this.em.merge(esame);
	}
	
	public void associaTipologiaEsameAdEsame(TipologiaEsame tipologia) {
		this.esame.setTipologiaEsame(tipologia);
		this.em.merge(esame);
	}
	
	public void impostaDataPrenotazioneAdEsame(Esame esame, Date dataPrenotazione) {
		this.esame.setDataPrenotazione(dataPrenotazione);
		this.em.merge(esame);
	}

	public void associaMedicoAdEsame(Medico medico, Esame esame) {
		this.esame.setMedico(medico);
		this.em.merge(esame);
		
	}
	
	

}