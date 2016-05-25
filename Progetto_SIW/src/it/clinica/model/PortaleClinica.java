package it.clinica.model;

public class PortaleClinica {
	private Clinica clinica;
	private Esame esameCorrente;
	private Admin adminCorrente;
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
	public Admin getAdminCorrente() {
		return adminCorrente;
	}
	public void setAdminCorrente(Admin adminCorrente) {
		this.adminCorrente = adminCorrente;
	}
	public TipologiaEsame getTipologiaEsameCorrente() {
		return tipologiaEsameCorrente;
	}
	public void setTipologiaEsameCorrente(TipologiaEsame tipologiaEsameCorrente) {
		this.tipologiaEsameCorrente = tipologiaEsameCorrente;
	}
}
