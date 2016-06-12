<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
 <%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
 
<!DOCTYPE html>
<html lang="it">
 
<head>
<meta charset="utf-8">
<title>Inserimento nuova Tipologia Esame</title>
</head>
 
 
<body>
    <f:view>
 
        <h1>Inserisci la nuova Tipologia di Esame</h1>
 
        <h:form>
            <p>
                Nome:
                <h:inputText value="#{tipologiaEsameController.nome}" />
           
                Descrizione :
                <h:inputText value="#{tipologiaEsameController.descrizione}" />
           
                Costo
                <h:inputText value="#{tipologiaEsameController.costo}" />
            </p>
          
            <br><h2>Prerequisiti richiesti:</h2>
            <c:forEach var="prerequisito"
                items="#{tipologiaEsameController.getTuttiIPrerequisiti()}">
                <br>
                <h:selectBooleanCheckbox value="#{tipologiaEsameController.addPrerequisito(prerequisto)}"/>${prerequisito.descrizione}
            </c:forEach>
 			
 			<br><h2>Risultati Proposti:</h2>
            <c:forEach var="risultato"
                items="#{tipologiaEsameController.getTuttiIRisultati()}">
                <br>
                <h:selectBooleanCheckbox />${risultato.nome}
            </c:forEach>
         
           <br>
            <h:commandButton value="Inserisci"
                action="#{tipologiaEsameController.creaTipologiaEsame()}" />
        </h:form>
 
    </f:view>
</body>
 
</html>