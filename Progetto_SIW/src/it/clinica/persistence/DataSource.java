package it.clinica.persistence;

import java.sql.*;
import it.clinica.exception.*;

public class DataSource {
	private String dbURI = "jdbc:postgresql://localhost/clinica";
	private String userName = "postgres";
	private String password = "postgres";

	public Connection getConnection() throws PersistenceException {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURI,userName,password);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e.getMessage());
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}

}
