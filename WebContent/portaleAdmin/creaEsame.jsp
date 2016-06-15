<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Inserimento esame</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inizia La compilazione di una nuovo prenotazione Esame</title>
</head>
<body>
	<f:view>

		<h:form>
			<h1>Inizia complilazione esame</h1>
		
		<div>Inserisci La data della visita (formato **-**-****)</div>
		<div><h:inputText value="#{esameController.dataVisita}">
				<f:convertDateTime pattern="dd-MM-yyyy" />
			</h:inputText></div>
		
		<div>Inserisci ID Paziente:</div>
		<div><h:inputText value="#{esameController.id_utente}"/></div>
		
		<div>Inserisci ID Medico:</div>
		<div><h:inputText value="#{esameController.nome_medico}"/></div>
		
		<div><h:commandButton value="Inserisci"	action="#{esameController.creaEsame()}"/></div>

		</h:form>
	</f:view>
</body>
</html>