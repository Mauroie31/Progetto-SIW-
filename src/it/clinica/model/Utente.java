package it.clinica.model;

import javax.persistence.*;
@Entity
@Table(name = "Utente")
@NamedQueries({
@NamedQuery(name = "findAllUtenti", 
query = "SELECT u FROM Utente u group by u.cognome"),
@NamedQuery(name = "findAllPazienti", 
query = "SELECT p FROM Utente p where p.ruolo = paziente group by p.cognome"),
@NamedQuery(name = "findAllAmministratori", 
query = "SELECT a FROM Utente a where a.ruolo = admin group by a.cognome"),
@NamedQuery(name = "findPazienteByEsame", 
query = "SELECT p FROM Utente p JOIN Esame e where e.id = :id_esame"),
@NamedQuery(name = "findUtenteByEmail", 
query = "SELECT u FROM Utente u where u.email = :email_utente")
})
public class Utente {
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
	private String indirizzo; //se è un admin non è necessario
	
	public Utente() {}

	public Utente(String nome, String cognome, String email, String password, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.ruolo = "paziente"; //se è un admin, si modifica il database
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

}
