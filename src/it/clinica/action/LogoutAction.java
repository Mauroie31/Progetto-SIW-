package it.clinica.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {

	public LogoutAction() {
		//empty
	}

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		HttpSession session = request.getSession();
		session.removeAttribute("utente");
		String esito = "logout";
		return esito;
	}
}
