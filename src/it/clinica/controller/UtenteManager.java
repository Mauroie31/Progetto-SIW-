package it.clinica.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;

import it.clinica.model.Utente;

@ManagedBean(name = "utenteManager")
@SessionScoped
public class UtenteManager {
	private Utente current;

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.jsp?faces-redirect=true";
	}

	public void login(Utente u) {
		this.current=u;
	}

	public Utente getUtente() {
		return this.current;
	}

	public boolean isLogged() {
		return this.current!=null;
	}



}
