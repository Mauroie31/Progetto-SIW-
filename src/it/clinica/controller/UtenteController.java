package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedProperty;

import it.clinica.facade.UtenteFacade;
import it.clinica.model.Utente;

@ManagedBean(name="utenteController")
@RequestScoped
public class UtenteController {
	@EJB(name = "utenteFacade")
	private UtenteFacade utenteFacade;
	private Long id;
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String ruolo;
	
	@ManagedProperty(value = "#{utenteManager}")
	private UtenteManager session;

	
	public UtenteController() {
		
	}
	
	public String login(Utente utente) {
		utente = utenteFacade.autentica(utente.getEmail(), utente.getPassword());
		if(utente!=null) {
			if(utente.getRuolo() == "admin") {
				this.session.login(utente);
				return "/PortaleAdmin/portaleAdmin.jsp";
			}
			if(utente.getRuolo() == "user") {
				this.session.login(utente);
				return "/PortalePaziente/portalePaziente.jsp";
			}
		}
		return "/error.jsp";
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	


}
