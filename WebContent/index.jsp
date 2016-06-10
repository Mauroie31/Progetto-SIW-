<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inizia Nuovo Esame</title>
<form>
	inizia complilazione esame
	
	<div> Nome: <h:inputText value="#{EsameController.nome }" /> </div>
	<div> Descrizione  <h:inputText value="#{EsameController.descrizione }"/> </div>
	<div><h:commandButton value="invia"  action="#{EsameController.creaEsame}" /></div>
	
	
</form>
</head>
<body>

</body>
</html>