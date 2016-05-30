package it.clinica.dao;

import it.clinica.model.Medico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MedicoDao extends AbstractDao<Medico> {

	public MedicoDao(EntityManager em) {
		super(em);
	}

	@Override
	public Medico findById(long id) {
		return this.getEntityManager().find(Medico.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> findAll() {
		Query query = this.getEntityManager().createQuery("SELECT m FROM Medici m");
		return query.getResultList();
	}

	public Medico findMedicoByEsame(Long id_esame) {
		Query query = this.getEntityManager().createQuery("SELECT m FROM Medici m JOIN Esami e where e.id = :id_esame");
		query.setParameter("id_esame", id_esame);
		return (Medico) query.getSingleResult();		
	}

	@SuppressWarnings("unchecked")
	public List<Medico> findMediciByTipologiaEsame(Long id_tipologiaEsame) {
		Query query = this.getEntityManager().createQuery("SELECT m FROM Medici m JOIN TipologiaEsame t where t.id = :id_tipologiaEsame");
		query.setParameter("id_tipologiaEsame", id_tipologiaEsame);
		return query.getResultList();
	}
}
