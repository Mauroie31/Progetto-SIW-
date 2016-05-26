package it.clinica.model;

import it.clinica.persistence.*;
import javax.persistence.*;

public class Facade {
	private EntityManager em;

	public Facade() {
		this.em = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = Factory.getInstance().createEntityManager();
		return em;
	}

	public void inserisciUtente(Utente utente) {
		this.em.getTransaction().begin();
		UtenteDao utenteDao = new UtenteDao(this.em);
		utenteDao.save(utente);
		this.em.getTransaction().commit();
	}

	public void inserisciEsame(Esame esame) {
		this.em.getTransaction().begin();
		EsameDao esameDao = new EsameDao(this.em);
		esameDao.save(esame);
		this.em.getTransaction().commit();
	}

	public void inserisciMedico(Medico medico) {
		this.em.getTransaction().begin();
		MedicoDao medicoDao = new MedicoDao(this.em);
		medicoDao.save(medico);
		this.em.getTransaction().commit();
	}

	public void inserisciTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.em.getTransaction().begin();
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(this.em);
		tipologiaEsameDao.save(tipologiaEsame);
		this.em.getTransaction().commit();
	}
}

