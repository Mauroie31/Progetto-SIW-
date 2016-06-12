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
        cacca
            <<div>
                Nome:
                <h:inputText value="#{tipologiaEsameController.nome}" />
            </div>
            <div>
                Descrizione :
                <h:inputText value="#{tipologiaEsameController.descrizione}" />
            </div>
            <div>
                Costo
                <h:inputText value="#{tipologiaEsameController.costo}" />
            </div>
            <c:forEach var="prerequisito"
                items="#{tipologiaEsameController.getPrerequisiti()}">
                <br>
                <h:selectBooleanCheckbox nome="prerequsiti" />#{prerequisito.descrizione}
            </c:forEach>
 
            <c:forEach var="risultato"
                items="#{tipologiaEsameController.getRisultati()}">
                <br>
                <h:selectBooleanCheckbox value="#{risultato.nome}" />
            </c:forEach>
            <h:commandButton value="Inserisci"
                action="#{tipologiaEsameController.creaTipologiaEsame()}" />
        </h:form>
 
    </f:view>
</body>
 
</html>