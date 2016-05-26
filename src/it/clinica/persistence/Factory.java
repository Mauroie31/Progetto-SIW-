package it.clinica.persistence;

import javax.persistence.*;

public class Factory {

	private static final String PERSISTENCE_UNIT_NAME = "clinica-unit";
	private static EntityManagerFactory emf;

	public static synchronized EntityManagerFactory getInstance() {
		if(emf == null)
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return emf;
	}

	public void closeEnityManagerFactory() {
		if(emf.isOpen()) {
			emf.close();
			
		}
	}
}