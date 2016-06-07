package it.clinica.action;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import it.clinica.model.Facade;

@ManagedBean
@RequestScoped
@EJB(name = "facade", beanInterface = Facade.class) 
public abstract class Action {
	@EJB(name = "facade")
	private Facade facade;

	public abstract String esegui(HttpServletRequest request) throws ServletException; {
	}

}
