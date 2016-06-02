package it.clinica.model;

import it.clinica.dao.*;
import it.clinica.persistence.*;

import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless(name="facade")
public class Facade {
	@PersistenceContext(unitName="unit-clinica")
	private EntityManager em;

	public Facade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return em;
	}

	//Metodi Utente
	public void inserisciUtente(Utente utente) {
		this.em.getTransaction().begin();
		UtenteDao utenteDao = new UtenteDao(this.em);
		utenteDao.save(utente);
		this.em.getTransaction().commit();
	}

	public Utente findUtenteByEmail(String email) {
		UtenteDao utenteDao = new UtenteDao(this.em);
		this.em.getTransaction().begin();
		Utente utente = utenteDao.findUtenteByEmail(email);
		this.em.getTransaction().commit();
		return utente;
	}

	//Metodi Esame
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

	//Metodi Medico
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

	//Metodi TipologiaEsame
	public void inserisciTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.em.getTransaction().begin();
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(this.em);
		tipologiaEsameDao.save(tipologiaEsame);
		this.em.getTransaction().commit();
	}

	public TipologiaEsame findTipologiaEsame(Long id_tipologiaEsame) {
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		TipologiaEsame tipologiaEsame = tipologiaEsameDao.findById(id_tipologiaEsame);
		this.em.getTransaction().commit();
		return tipologiaEsame;
	}

	public List<TipologiaEsame> findAllTipologieEsami() {
		TipologiaEsameDao dao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		List<TipologiaEsame> result = dao.findAll();
		this.em.getTransaction().commit();
		return result;
	}

	public TipologiaEsame findTipologiaEsameByEsame(Long id_esame) {
		TipologiaEsameDao dao = new TipologiaEsameDao(this.em);
		this.em.getTransaction().begin();
		TipologiaEsame tipologiaEsame = dao.findTipologiaEsameByEsame(id_esame);
		this.em.getTransaction().commit();
		return tipologiaEsame;
	}

	//Metodi Paziente
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

	public void setEsameToPaziente(Paziente paziente, Long idEsame, Esame esame) {
		paziente.getEsami().put(idEsame, esame);
		PazienteDao dao = new PazienteDao(this.em);
		this.em.getTransaction().begin();
		dao.update(paziente);
		this.em.getTransaction().commit();
	}


	public Utente autentica(String email, String password) {
		Utente utente = null;
		UtenteDao utenteDao = new UtenteDao(this.em);

		try {
			Utente temp;
			temp = utenteDao.findUtenteByEmail(email);
			if(temp != null && temp.getPassword()!= null && temp.getPassword().equals(password))
				utente=temp;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return utente;

	}

}