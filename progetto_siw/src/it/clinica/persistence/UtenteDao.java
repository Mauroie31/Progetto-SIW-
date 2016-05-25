package it.clinica.persistence;

import it.clinica.exception.*;
import it.clinica.model.*;

public interface UtenteDao {

	boolean insert(String nome, String cognome, String indirizzo, String email,
			String username, String password) throws PersistenceException;

	public Utente findById(Long id) throws PersistenceException;

	public Paziente findByEsame(Esame esame) throws PersistenceException;
}