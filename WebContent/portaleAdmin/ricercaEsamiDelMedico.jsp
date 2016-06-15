<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
		
		<div>Inserisci ID Medico:</div>
		<div><h:inputText id="id_medico" value="#{medicoController.nome}"/></div>
		<div><h:commandButton value="Inserisci"	action="#{medicoController.cercaMedico()}"/></div>
		
		</h:form>
	</f:view>
</body>
</html>