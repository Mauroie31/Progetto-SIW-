package it.clinica.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import it.clinica.facade.AmministratoreFacade;

@ManagedBean(name="amministratoreController")
public class AmministratoreController {

	@EJB(name = "amministratoreFacade")
    private AmministratoreFacade amministratoreFacade;
	private String ruolo;
	
	public AmministratoreController() {
		
	}
	
	public AmministratoreFacade getAmministratoreFacade() {
		return amministratoreFacade;
	}
	public void setAmministratoreFacade(AmministratoreFacade amministratoreFacade) {
		this.amministratoreFacade = amministratoreFacade;
	}
	
	
	
	
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
