package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.UtenteFacade;

@ManagedBean
@RequestScoped
@EJB(name = "utenteFacade", beanInterface = UtenteFacade.class) 
public class UtenteController {
	@EJB(name = "utenteFacade")
	private UtenteFacade utenteFacade;


}
