<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggiungi prerequisiti</title>
</head>
<body>
    <f:view>
    <h1> Aggiungi prerequisiti </h1>
    <h:form>
       
        ${tipologiaEsameController.tipologia.id}
       
        <c:forEach var="prerequisito"
            items="#{tipologiaEsameController.getTuttiIPrerequisiti()}">
            <br>
                ${prerequisito.descrizione} <h:commandButton value="Inserisci" action="#{tipologiaEsameController.addPrerequisiti(prerequisito)}" />
        </c:forEach>
        <br><h:commandButton value="Inserisci"
                action="#{tipologiaEsameController.tipologiaInserita()}" />
    </h:form>
    </f:view>
   
</body>
</html>