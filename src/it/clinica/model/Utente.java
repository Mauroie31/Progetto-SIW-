package it.clinica.model;

import javax.persistence.*;
@Entity
@Table(name = "Utenti")
@NamedQuery(name = "findAllUtenti", query = "SELECT u FROM Utenti u")
public abstract class Utente {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @Column(nullable = false)
	private String nome;
    @Column(nullable = false)
	private String cognome;
    @Column(unique=true, nullable=false)
	private String email;
    @Column(nullable = false)
	private String password;
    @Column(nullable = false)
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
