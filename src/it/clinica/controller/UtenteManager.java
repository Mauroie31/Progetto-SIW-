package it.clinica.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;

import it.clinica.model.Utente;

@ManagedBean(name = "utenteManager")
@SessionScoped
public class UtenteManager {
	private static Utente utente;
	
	public UtenteManager() {}

	public static Utente getUtente() {
		return utente;
	}

	public static void setUtente(Utente current) {
		UtenteManager.utente = current;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setUtente(null);
		return "./../index.jsp?faces-redirect=true";
	}

	public void login(Utente u) {
		UtenteManager.utente=u;
	}


    public static void sessionCheckerUtenteAmministratore(){
        if(utente==null)
            try {
                redirectPage("./../nessunAccesso.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        else
            if(getUtente().getRuolo().equals("paziente")) {
                try {
                    redirectPage("./../portalePaziente/portalePaziente.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }}
    }
    
    
    
    public static void redirectPage(String page) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(page);
	}
}
