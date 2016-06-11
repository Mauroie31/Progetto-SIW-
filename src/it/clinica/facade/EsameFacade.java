package it.clinica.facade;

import java.sql.Date;
import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinica.dao.EsameDao;
import it.clinica.model.Esame;
import it.clinica.model.Paziente;
import it.clinica.model.TipologiaEsame;

@Stateless(name="EsameFacade")
public class EsameFacade {
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public EsameFacade(EntityManager em) {
		this.em = em;
	}
	
	public void UpdateEsame(Esame esame) {
		this.em.getTransaction().begin();
		EsameDao esameDao = new EsameDao(this.em);
		esameDao.update(esame);
		this.em.getTransaction().commit();
	}
	
	public Esame createEsame(String nome, String descrizione) {
		Esame esame = new Esame();
		esame.setNome(nome);
		esame.setDescrizione(descrizione);
		this.em.persist(esame);
		return esame;
	}
	
	//TODO
	/*
	public Esame createEsame(String nome,
			String descrizione, Map<String, String> risultati, java.util.Date dataPrenotazione, java.util.Date dataVisita,
			TipologiaEsame tipologiaEsame, Paziente paziente, Medico medico) {
		Esame esame = new Esame();
		esame.setNome();
		esame.setDescrizione(descrizione);
		esame.setRisultati(risultati);
		esame.setDataPrenotazione(dataPrenotazione);
		esame.setDataVisita(dataVisita);
		esame.setTipologiaEsame(tipologiaEsame);
		esame.setPaziente(paziente);
		esame.setMedico(medico);
		this.em.persist(esame);
		return esame;
	}
	*/
	
	
	public void inserisciEsame(Esame esame) {
		this.em.getTransaction().begin();
		EsameDao esameDao = new EsameDao(this.em);
		esameDao.save(esame);
		this.em.getTransaction().commit();
	}

	public Esame findEsame(Long id_esame) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		Esame esame = esameDao.findById(id_esame);
		this.em.getTransaction().commit();
		return esame;
	}

	public List<Esame> findAllEsami() {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findAll();
		this.em.getTransaction().commit();
		return esami;
	}

	public List<Esame> findEsamiByPaziente(Long id_paziente) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findEsamiByPaziente(id_paziente);
		this.em.getTransaction().commit();
		return esami;
	}

	public List<Esame> findEsamiByMedico(Long id_medico) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findEsamiByPaziente(id_medico);
		this.em.getTransaction().commit();
		return esami;
	}

	public List<Esame> findEsamiByDataPrenotazione(Date datap) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findEsamiByDataPrenotazione(datap);
		this.em.getTransaction().commit();
		return esami;
	}

	public List<Esame> findEsamiByDataVisita(Date datav) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findEsamiByDataVisita(datav);
		this.em.getTransaction().commit();
		return esami;
	}

	public List<Esame> findEsamiByTipologia(Long id_tipologia) {
		EsameDao esameDao = new EsameDao(this.em);
		this.em.getTransaction().begin();
		List<Esame> esami = esameDao.findEsamiByTipologiaEsame(id_tipologia);
		this.em.getTransaction().commit();
		return esami;
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
