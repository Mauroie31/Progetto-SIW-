package it.clinica.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class Autentica extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String prossimaPagina = "/error.jsp";
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String prossimaPagina= "/error.jsp";
	}

}
