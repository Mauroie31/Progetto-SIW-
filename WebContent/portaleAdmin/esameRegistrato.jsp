<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.clinica.model.Esame"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dati dell'esame</title>
</head>
<body>
	<br> Nome: <% out.print(((Esame) request.getAttribute("esame")).getNome()); %>
	<br> Descrizione: <% out.print(((Esame) request.getAttribute("esame")).getDescrizione()); %>
</body>
</html>