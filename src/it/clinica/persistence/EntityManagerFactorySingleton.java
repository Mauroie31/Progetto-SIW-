package it.clinica.persistence;

import javax.persistence.*;

/*
 * 
 * Si occupa di creare oggetti EntityManager
 * garantendo che soltanto un'unica istanza 
 * della classe stessa possa essere creata
 * all'interno di un programma
 */

public class EntityManagerFactorySingleton {

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