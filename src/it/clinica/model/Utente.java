package it.clinica.model;

import javax.persistence.*;
@Entity
@Table(name = "DIPENDENTI")
@NamedQuery(name="GetUtenteById", query = "SELECT u FROM Utente u WHERE u.nome = :nomeU")
public abstract class Utente {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String password;
	private String ruolo;

	public Utente() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
