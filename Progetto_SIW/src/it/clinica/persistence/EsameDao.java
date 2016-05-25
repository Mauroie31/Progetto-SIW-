package it.clinica.persistence;

import it.clinica.exception.*;
import it.clinica.model.*;
import java.util.*;

public interface EsameDao {

	/* Genera un id per l'esame inserito nel database */
	public Long generaID() throws PersistenceException;

	/* Inserisce un esame nel database */
	public boolean insert(Esame esame) throws PersistenceException;

	/* Aggiorna un esame nel database */
	public boolean update(Esame esame) throws PersistenceException;

	/* Cancella un esame dal database */
	boolean delete(Esame esame) throws PersistenceException;

	/* Restituisce un esame andando a cercarlo nel database per chiave primaria */
	public Esame findById(Long idEsame) throws PersistenceException;

	/* Restituisce la lista degli esami di un paziente */
	public Map<String, Esame> findByIdCliente(Paziente paziente) throws PersistenceException;

}
