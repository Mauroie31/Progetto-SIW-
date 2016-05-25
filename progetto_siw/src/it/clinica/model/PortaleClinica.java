package it.clinica.model;

public class PortaleClinica {
	private Clinica clinica;
	private Esame esameCorrente;
	private Amministratore amministratoreCorrente;
	private TipologiaEsame tipologiaEsameCorrente;
	
	
	
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	public Esame getEsameCorrente() {
		return esameCorrente;
	}
	public void setEsameCorrente(Esame esameCorrente) {
		this.esameCorrente = esameCorrente;
	}
	public Amministratore getAmministratoreCorrente() {
		return amministratoreCorrente;
	}
	public void setAmministratoreCorrente(Amministratore amministratoreCorrente) {
		this.amministratoreCorrente = amministratoreCorrente;
	}
	public TipologiaEsame getTipologiaEsameCorrente() {
		return tipologiaEsameCorrente;
	}
	public void setTipologiaEsameCorrente(TipologiaEsame tipologiaEsameCorrente) {
		this.tipologiaEsameCorrente = tipologiaEsameCorrente;
	}
}
