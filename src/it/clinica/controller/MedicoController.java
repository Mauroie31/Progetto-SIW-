package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import it.clinica.facade.MedicoFacade;

@ManagedBean
@RequestScoped
@EJB(name = "medicoFacade", beanInterface = MedicoFacade.class) 
public class MedicoController {
	@EJB(name = "medicoFacade")
	private MedicoFacade medicoFacade;


}
