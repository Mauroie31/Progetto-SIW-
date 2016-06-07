package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.TipologiaEsameFacade;

@ManagedBean
@RequestScoped
@EJB(name = "tipologiaEsameFacade", beanInterface = TipologiaEsameFacade.class) 
public class TipologiaEsameController {
	@EJB(name = "tipologiaEsameFacade")
	private TipologiaEsameFacade tipologiaEsameFacade;


}
