package it.clinica.dao;

import java.util.*;

import javax.persistence.*;

import it.clinica.model.*;

public class UtenteDao extends AbstractDao<Utente> {

	public UtenteDao(EntityManager em) {
		super(em);
	}

	@Override
	public Utente findById(long id) {
		return this.getEntityManager().find(Utente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT u FROM Utenti u");
		return query.getResultList();
	}
	

	public Utente findUtenteByEmail(String email_utente) {
		Query query = this.getEntityManager().createQuery("SELECT u FROM Utenti u JOIN where u.email = :email_utente");
		query.setParameter("email_utente", email_utente);
		return (Utente) query.getSingleResult();
	}
}