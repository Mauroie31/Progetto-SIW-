package it.clinica.action;

import java.util.Date;
import java.util.List;

import it.clinica.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionCreaEsame extends Action {

	public ActionCreaEsame() {
	}

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {

		HttpSession session = request.getSession();
		String esito = "erroreEsame";

		Esame esame = new Esame();

		Paziente paziente = (Paziente) session.getAttribute("paziente");
		esame.setPaziente(paziente);
		TipologiaEsame tipologiaEsame = new TipologiaEsame();
		esame.setTipologiaEsame(tipologiaEsame);
		Date dataPrenotazione = new Date();
		esame.setDataPrenotazione(dataPrenotazione);
		Date dataVisita = (Date) session.getAttribute("dataVisita");
		esame.setDataVisita(dataVisita);

		facade.inserisciEsame(esame);
		List<Esame> esami = facade.findAllEsami();
		esami.add(esame);

		if (esami != null) {
			session.setAttribute("esame", esame);
			session.setAttribute("paziente", paziente);
			session.setAttribute("esami", esami);
			session.setAttribute("tipologiaEsame", tipologiaEsame);
			session.setAttribute("dataPrenotazione", dataPrenotazione);
			session.setAttribute("dataVisita", dataVisita);
			esito = "esameOK";
		}
		return esito;
	}

}
