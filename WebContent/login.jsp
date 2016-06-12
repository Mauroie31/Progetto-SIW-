<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
 
<!DOCTYPE html>
<html lang="it">
 
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<f:view>


		<h:form>
<div>
Email:
			<h:inputText value="#{utenteController.email}" />
			</div>

<div>
Password:
			<h:inputText value="#{utenteController.password}" />
			</div>
	<!--  		
			<label> <input type="checkbox"> Ricordami
			</label> -->
<div>
			<h:commandButton value="accedi" action="#{utenteController.login()}" />
</div>
		</h:form>
	</f:view>

</body>

</html>