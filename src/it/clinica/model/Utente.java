package it.clinica.model;

import javax.persistence.*;
@Entity
@Table(name = "Utenti")
@NamedQuery(name="GetUtenteById", query = "SELECT u FROM Utente u WHERE u.id = : idU")
public abstract class Utente {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)  
	private String username;
    @Column(nullable = false)
	private String nome;
    @Column(nullable = false)
	private String cognome;
	private String email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
