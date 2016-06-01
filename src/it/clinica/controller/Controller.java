package it.clinica.controller;

import java.io.IOException;

import it.clinica.model.Facade;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/controller/*") 
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName="facade")
	private Facade facade;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = null; //da cambiare
	}
}
