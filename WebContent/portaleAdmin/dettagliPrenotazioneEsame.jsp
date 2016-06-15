<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dettagli Prenotazione Esame</title>
</head>
<body>
	<f:view>
		<h:form>
	
	<div>Secgli una tipologia</div>
		
		<c:forEach var="tipologiaEsame" items="#{tipologiaEsameController.tipologieEsami}">
							<br>
           ${tipologiaEsame.nome}  
            <h:commandButton action="#{esameController.setTipologiaPerPrenotazioneEsame(tipologiaEsame)}" /><br>
		</c:forEach>
	            <h:commandButton value="Fine Inserimento" action="#{esameController.goToPaginaFineInserimentoPrenotazioneEsame()}" /><br>
	
	</h:form>
	</f:view>

</body>
</html>