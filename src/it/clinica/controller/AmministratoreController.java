package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import it.clinica.facade.AmministratoreFacade;

@ManagedBean
@RequestScoped
@EJB(name = "amministratoreFacade", beanInterface = AmministratoreFacade.class) 
public class AmministratoreController {
	@EJB(name = "amministratoreFacade")
    private AmministratoreFacade amministratoreFacade;

}
