package it.clinica.dao;

import java.util.*;

import javax.persistence.EntityManager;

import it.clinica.model.Esame;

public class EsameDao extends AbstractDao<Esame> {

	public EsameDao(EntityManager em) {
		super(em);
	}

	@Override
	public Esame findById(long id) {
		return this.getEntityManager().find(Esame.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Esame> findAll() {
		return this.getEntityManager().createNamedQuery("Esame.findAll").getResultList();
	}
	
	// TODO
	public List<Esame> findEsamiByUserNamePaziente(String username) {
		return null;
	}
	
	//TODO 
	public List<Esame> findEsamibyIdMedico (long id_medico) {
		return null;
	}
	
	//Todo
	public List<Esame> findEsamiByDataPrenotazione(Date data) {
		return null;
	}
	
	//Todo
	public List<Esame> findEsamyBydataVisita(Date data) {
		return null;
	}
	
	

	
}
