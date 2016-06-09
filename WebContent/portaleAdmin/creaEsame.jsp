<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Inserimento esame</title>
</head>
<body>
<f:view>
<h:form>
    <div>Nome: <h:inputText value="#{EsameController.nome}"  /></div>
    <div>Descrizione: <h:inputText value="#{EsameController.descrizione}"  /></div>
    
    <div><h:commandButton value="Submit"  action="#{esameController.createEsame}"/></div>
</h:form>
</f:view>
</body>
</html>
