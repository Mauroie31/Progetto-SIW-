package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.RisultatiFacade;

@ManagedBean
@RequestScoped
@EJB(name = "risultatiFacade", beanInterface = RisultatiFacade.class) 
public class RisultatiController {
	@EJB(name = "risultatiFacade")
	private RisultatiFacade risultatiFacade;


}
