package it.clinica.action;
import javax.servlet.*;
import javax.servlet.http.*;

import it.clinica.facade.Facade;
import it.clinica.model.Utente;

public class LoginAction extends Action {
	
	public LoginAction() {
	}
	
	public String esegui(HttpServletRequest request) throws ServletException{
		Facade facade = new Facade();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = facade.autentica(email, password);
		String esito = "OK";
		if(utente !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utente", utente);
			return esito;
		} else
			esito ="KO";
			return esito;
	}
}
