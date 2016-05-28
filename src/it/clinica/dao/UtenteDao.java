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
		return this.getEntityManager().createNamedQuery("Utente.findAll").getResultList();
	}
}