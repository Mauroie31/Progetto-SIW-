package it.clinica.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.clinica.model.Utente;

@ManagedBean(name = "utenteManager")
@SessionScoped
public class UtenteManager {
	private Utente utente;

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.jsp?faces-redirect=true";
	}

	public void login(Utente u) {
		this.utente=u;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}



}
