package it.clinica.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinica.facade.UtenteFacade;
import it.clinica.model.*;
import it.clinica.password.MD5Encrypter;

@ManagedBean(name="loginController")
public class LoginController {
	@EJB(name = "utenteFacade")
	private UtenteFacade utenteFacade;
	private Long id;
	private String nome, cognome, email, password, indirizzo, ruolo;
	private Utente utente;
	private List<Utente> utenti;

	@ManagedProperty(value = "#{utenteManager}")
	private UtenteManager session;


	public LoginController() {		
	}

	@PostConstruct
	public void init() {
		this.utenti = this.utenteFacade.findAllUtenti();
	}

	public String goToPaginaRegistrazione() {
		return "/registrazione.jsp";
	}

	public String creaUtente() {
		this.utente = new Utente(nome, cognome, email, password, indirizzo);
		String passwordCriptata = MD5Encrypter.cryptWithMD5(password);
		this.utente.setPassword(passwordCriptata);
		this.utenteFacade.inserisciUtente(this.utente);
		return "/registrazioneUtenteTerminata.jsp";
	}

	public String login() {
		try {
			this.utente = utenteFacade.findUtenteByEmail(email);
		}catch (EJBException e) {
			return "errorPage.jsp";
		}
		if(utente.getRuolo().equals("admin") && MD5Encrypter.cryptWithMD5(this.password).equals(utente.getPassword())) {
			this.session.login(utente);
			return "/portaleAdmin/accessoEffettuato.jsp";
		} else if (MD5Encrypter.cryptWithMD5(this.password).equals(utente.getPassword())) {
			this.session.login(utente);
			return "/portalePaziente/accessoEffettuato.jsp";
		} else return "errorPage.jsp";
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