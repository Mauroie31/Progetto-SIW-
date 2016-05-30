package it.clinica.action;
import javax.servlet.*;
import javax.servlet.http.*;

import it.clinica.model.Facade;
import it.clinica.model.Utente;

public class LoginAction {
	
	public LoginAction() {
	}
	
	public String esegui(HttpServletRequest request) throws ServletException{
		Facade authservice = new Facade();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = authservice.autentica(email, password);
		if(utente !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utente", utente);
			return "OK";
		} else
			return "KO";
		
	}
}
