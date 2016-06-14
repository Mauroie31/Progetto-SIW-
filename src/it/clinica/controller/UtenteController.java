package it.clinica.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinica.facade.UtenteFacade;
import it.clinica.model.Utente;

@ManagedBean(name="utenteController")
public class UtenteController {
	@EJB(name = "utenteFacade")
	private UtenteFacade utenteFacade;
	private Long id;
	private String nome, cognome, email, password, indirizzo, ruolo;
	private Utente utente;
	private List<Utente> utenti;

	@ManagedProperty(value = "#{utenteManager}")
	private UtenteManager session;


	public UtenteController() {		
	}

	@PostConstruct
	public void init() {
		this.utenti = this.utenteFacade.findAllUtenti();
		this.ruolo = "paziente";
	}

	public String goToPaginaRegistrazione() {
		return "/registrazione.jsp";
	}

	public String creaUtente() {
		this.utente = new Utente(nome, cognome, email, password, indirizzo);
		this.utenteFacade.inserisciUtente(this.utente);
		return "/registrazioneUtenteTerminata.jsp";
	}





	public String login( ) {
		this.email = this.email.trim();
		Utente utente = utenteFacade.findUtenteByEmail(this.email);
		if(utente != null) {
			if(this.email == "admin" && this.password == "admin") {
				this.session.login(utente);
				return "/portaleAdmin/portaleAdmin.jsp";
			}
			this.session.login(utente);
			return "/portalePaziente/portalePaziente.jsp";
		}
		return "errorPage.jsp";
	}







	public UtenteFacade getUtenteFacade() {
		return utenteFacade;
	}

	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public UtenteManager getSession() {
		return session;
	}

	public void setSession(UtenteManager session) {
		this.session = session;
	}
}