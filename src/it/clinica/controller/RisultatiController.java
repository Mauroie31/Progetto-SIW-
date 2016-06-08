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
	private Long id;
	private String chiave;
	private String valore;
	
	//Getters and Setters
	public RisultatiFacade getRisultatiFacade() {
		return risultatiFacade;
	}
	public void setRisultatiFacade(RisultatiFacade risultatiFacade) {
		this.risultatiFacade = risultatiFacade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	
	
	


}
