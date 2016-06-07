package it.clinica.controller;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.clinica.action.Action;
import it.clinica.facade.Facade;

@ManagedBean
@RequestScoped
@EJB(name = "facade", beanInterface = Facade.class) 
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Map<String, String> esito2pagina;
	private Map<String, String> comando2action;
	@EJB(name = "facade")
	private Facade facade;

	@SuppressWarnings("unused")
	private String leggiComando(String servletPath) {
		String comando = servletPath.substring(1, (servletPath.length()-3));
		return comando;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prossimaPagina = null;
		//   Returns the part of this request's URL that calls the servlet.
		String comando = request.getServletPath(); //TODO ?

		if(comando.equals("/Controller"))
			comando = (String) request.getAttribute("path");

		String nomeAction = this.comando2action.get(comando);

		if(nomeAction == null) {
			prossimaPagina = "/error.jsp";
		} else {
			Action action = null;

			try {
				action = (Action) Class.forName(nomeAction).newInstance();
				String esitoAction = action.esegui(request);
				prossimaPagina = this.esito2pagina.get(esitoAction);
			}
			catch (InstantiationException e) {
				prossimaPagina = "/error.jsp";
			} catch (IllegalAccessException e) {
				prossimaPagina = "/error.jsp";
			} catch (ClassNotFoundException e) {
				prossimaPagina = "/error.jsp";
			}

			ServletContext application = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
			rd.forward(request, response);
		}
	}

	//TODO
	public void init() {
		/**
		 * Bisogna riempire la mappa comando2action
		 * e esitoToAction
		 */
	}

}

