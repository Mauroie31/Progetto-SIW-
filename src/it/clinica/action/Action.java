package it.clinica.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public abstract class Action {

	public abstract String esegui(HttpServletRequest request) throws ServletException; {
	}

}
