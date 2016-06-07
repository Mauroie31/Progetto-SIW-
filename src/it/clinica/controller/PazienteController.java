package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.PazienteFacade;

@ManagedBean
@RequestScoped
@EJB(name = "pazienteFacade", beanInterface = PazienteFacade.class) 
public class PazienteController {
	@EJB(name = "pazienteFacade")
	private PazienteFacade pazienteFacade;


}
