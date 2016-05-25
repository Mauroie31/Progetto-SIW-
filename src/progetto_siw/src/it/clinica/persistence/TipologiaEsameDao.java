package it.clinica.persistence;

import it.clinica.exception.*;
import it.clinica.model.*;
import java.util.*;

public interface TipologiaEsameDao {

	public boolean insert(String nome, String descrizione, double costo) throws PersistenceException;

	public List<TipologiaEsame> findAll() throws PersistenceException;

	public TipologiaEsame findById(Long id) throws PersistenceException;
}
