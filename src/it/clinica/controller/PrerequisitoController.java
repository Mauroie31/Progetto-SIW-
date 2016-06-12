package it.clinica.controller;
import it.clinica.model.*;
import java.util.*;
import it.clinica.facade.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="prerequisitoController")
public class PrerequisitoController {
	
	@EJB(name="prerequisitoFacade")
	private PrerequisitoFacade prerequisitoFacade;
	
	
	 private String nome;
	 private String descrizione;
	 private List<TipologiaEsame> tipologieEsamePerQuestoPrerequisito;
	
	 public PrerequisitoController(){
	 }
	 
	 public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<TipologiaEsame> getTipologieEsamePerQuestoPrerequisito() {
		return tipologieEsamePerQuestoPrerequisito;
	}
	public void setTipologieEsamePerQuestoPrerequisito(List<TipologiaEsame> tipologieEsamePerQuestoPrerequisito) {
		this.tipologieEsamePerQuestoPrerequisito = tipologieEsamePerQuestoPrerequisito;
	}
	

}
