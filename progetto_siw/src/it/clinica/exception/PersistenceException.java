package it.clinica.exception;

public class PersistenceException extends Exception {
	private String message;

	public PersistenceException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
}