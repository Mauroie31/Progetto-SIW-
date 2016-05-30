package it.clinica.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import it.clinica.action.LoginAction;

public class Autentica extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String prossimaPagina = "/error.jsp";
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String prossimaPagina= "/error.jsp";
		LoginAction login = new LoginAction();
		String esito = login.esegui(request);
		if(esito.equals("OK"))
			prossimaPagina= "/risorsaProtetta.jsp"; //TODO
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);	
	}

}
