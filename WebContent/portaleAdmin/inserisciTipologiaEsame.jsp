<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento nuova Tipologia Esame</title>
</head>
<body>
	<h1>Inserisci la nuova Tipologia di Esame</h1>
	<p>
	Nome: <h:inputText value="#{tipologiaEsameController.nome}" />
	Descrizione :<h:inputText value="#{tipologiaEsameController.descrizione}" />
	Costo <h:inputText value="#{tipologiaEsameController.costo}" />
	<c:forEach var="prerequisito" items="${tipologiaEsameController.getPrerequisiti}">
			<br><input type="checkbox" name="prerequisito"/> #{prerequisito.descrizione}
	</c:forEach>
	<c:forEach var="risultato" items="${tipologiaEsameController.getRisultati}">
			<br><input type="checkbox" name="risultato"/> #{risultato.nome}
	</c:forEach>
	</p>
	<div><h:commandButton value="Submit" acLon="#{tipologiaEsameController.createProduct}"/></div>	

</body>
</html>