package it.clinica.facade;

import java.sql.Date;
import java.util.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.clinica.model.Esame;
import it.clinica.model.Paziente;
import it.clinica.model.TipologiaEsame;

@Stateless
@EJB(name="ejb/esameFacade", beanInterface=EsameFacade.class, beanName="esameFacade")
public class EsameFacade {
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public EsameFacade(EntityManager em) {
		this.em = em;
	}
	
	public EsameFacade() {
		
	}
	
	public Esame UpdateEsame(Esame esame) {
		return this.em.merge(esame);
	}
	
	public Esame createEsame(String nome, String descrizione) {
		Esame esame = new Esame();
		esame.setNome(nome);
		esame.setDescrizione(descrizione);
		this.em.persist(esame);
		return esame;
	}
	
	public void inserisciEsame(Esame esame) {
		this.em.persist(esame);
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

	public List<Esame> findEsamiByPaziente(Long id_paziente) {
		try {
			return this.em.createNamedQuery("findEsamiByPaziente", Esame.class)
					.setParameter("id_paziente", id_paziente).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Esame> findEsamiByMedico(Long id_medico) {
		try {
			return this.em.createNamedQuery("findEsamiByMedico", Esame.class)
					.setParameter("id_medico", id_medico).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Esame> findEsamiByDataPrenotazione(Date datap) {
		try {
			return this.em.createNamedQuery("findEsamiByDataPrenotazione", Esame.class)
					.setParameter("dataPrenotazione", datap).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Esame> findEsamiByDataVisita(Date datav) {
		try {
			return this.em.createNamedQuery("findEsamiByDataVisita", Esame.class)
					.setParameter("dataVisita", datav).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Esame> findEsamiByTipologia(Long id_tipologia) {
		try {
			return this.em.createNamedQuery("findEsamiByTipologia", Esame.class)
					.setParameter("id_tipologiaEsame", id_tipologia).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void associaPazienteAdEsame(Paziente paziente, Esame esame) {
		esame.setPaziente(paziente);
		this.em.merge(esame);
	}
	
	public void associaTipologiaEsameAdEsame(TipologiaEsame tipologia, Esame esame) {
		esame.setTipologiaEsame(tipologia);
		this.em.merge(esame);
	}
	
	public void impostaDataPrenotazioneAdEsame(Esame esame, Date dataPrenotazione) {
		esame.setDataPrenotazione(dataPrenotazione);
		this.em.merge(esame);
	}
	
	

}
