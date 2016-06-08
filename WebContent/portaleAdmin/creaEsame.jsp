<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="it.clinica.model.*"%>
<%@ page import="java.util.*"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	Amministratore amministratore = (Amministratore) session.getAttribute("utente");
	boolean autorizzato = true;
	if (amministratore != null)
		autorizzato &= (amministratore.getRuolo().equals("admin"));
	else
		autorizzato = false;
	if (!autorizzato) {
		out.clear();
		RequestDispatcher rd = application
				.getRequestDispatcher("erroreLogin.jsp");
		rd.forward(request, response);
		return;
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento esame</title>
<link rel="stylesheet" type="text/css" href='media/stile.css'>
<style>
input,textarea {
	width: 200px;
}
</style>
</head>
<div align="right">
		Login:
		<%=utente.getRuolo()%>
		-
		<%=utente.getNome()%>
		<%=utente.getCognome()%>
		<form action="logout.do" method="get">
			<input type="submit" name="logout" value="Logout" />
		</form>
	</div>
	<br>
	<br>
	<br>
	<h1 align="center">
		Inserisci i dati dell'esame da aggiungere<span></span>
	</h1>
	<br>
	<h3 align="center"><font color="FF6600"> <%=(request.getAttribute("errore") != null) ? request
					.getAttribute("errore") : ""%></font></h3>
	<h2 align="center">
		<font color="red"> <%=(request.getAttribute("erroreChiave") != null) ? request
					.getAttribute("erroreChiave") : ""%>
		</font>
	</h2>
		<div id="form" align="center">
		<form action="inserimentoEsame.do" method="post">
			<b>Nome</b> <br> <input type="text" name="nomeP"
				value="<%=((request.getAttribute("nomeP") != null)) ? request
					.getAttribute("nomeP") : ""%>" />

			<%=(request.getAttribute("erroreNomeP") != null) ? request
					.getAttribute("erroreNomeP") : ""%>

			<br /> <br> <b>Descrizione</b><br> <input type="text"
				name="descrizione"
				value="<%=((request.getAttribute("descrizione") != null)) ? request
					.getAttribute("descrizione") : ""%>" />

			<%=(request.getAttribute("erroreDescrizione") != null) ? request
					.getAttribute("erroreDescrizione") : ""%>
					
					
					
<h1 align="center">Lista delle tipologie esami disponibili<span></span></h1>
	
	<%
		List<TipologiaEsame> tipologieEsami =  (List<TipologiaEsame>)session.getAttribute("tipologieEsami");
	%>


	<div align="center" id="form">
	<table border="2" class="tableStyle"><tr>
			<td><b>Nome</b></td>
			<td><b>Descrizione</b></td>
			<td><b>Costo</b></td>
		</tr>
		
		<%
			for (TipologiaEsame tipologiaEsame : tipologieEsami) {
		%>

		<tr>
			<td><%=tipologiaEsame.getNome()%></td>
			<td><%=tipologiaEsame.getDescrizione()%></td>
			<td><%=tipologiaEsame.getCosto()%></td>
			<td>
				<form action="scegliTipologiaEsame.do" method="post">
							
					<button class="classname_piccolo" type="submit" name="codTipologiaEsame"
						value="<%=tipologiaEsame.getId()%>">Aggiungi</button>
					</form>
			</td>
			<%
				}
			%>
		</tr>
	</table>
	</div>
	
	<br /> <br /> <br> <input type="submit" name="submit"
				value="AGGIUNGI" />
	
	</form>
	</div>
	
	<br />
	<p align="center">

		<A href="portaleAdmin.jsp" class="classname">Torna alla
			HOME Amministratore</A> <br /> <br> <a href="index.jsp"
			class="classname"> Torna alla HOME </a>
	</p>

</body>
</html>