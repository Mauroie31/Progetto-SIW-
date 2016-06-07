package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.clinica.facade.EsameFacade;

@ManagedBean
@RequestScoped
@EJB(name = "esameFacade", beanInterface = EsameFacade.class) 
public class EsameController {
	@EJB(name = "esameFacade")
    private EsameFacade esameFacade;

}
