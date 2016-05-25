package it.clinica.model;

import java.util.*;

public class TipologiaEsame {
	private String dettagli, codiceEsame;
	private Set<String> indicatoriEsami;
	private Map<String, String> prerequisiti;



	public String getDettagli() {
		return dettagli;
	}
	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}
	public String getCodiceEsame() {
		return codiceEsame;
	}
	public void setCodiceEsame(String codiceEsame) {
		this.codiceEsame = codiceEsame;
	}
	public Set<String> getIndicatoriEsami() {
		return indicatoriEsami;
	}
	public void setIndicatoriEsami(Set<String> indicatoriEsami) {
		this.indicatoriEsami = indicatoriEsami;
	}
	public Map<String, String> getPrerequisiti() {
		return prerequisiti;
	}
	public void setPrerequisiti(Map<String, String> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}
}
