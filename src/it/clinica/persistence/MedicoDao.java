package it.clinica.persistence;

import it.clinica.model.Medico;
import java.util.List;
import javax.persistence.EntityManager;

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
		return this.getEntityManager().createNamedQuery("Medico.findAll").getResultList();
	}

}
