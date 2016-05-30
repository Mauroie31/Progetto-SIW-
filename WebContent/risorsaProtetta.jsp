<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ page import="it.clinica.model.*"%>
    <% 
    Utente utente = (Utente) session.getAttribute("utente");
    boolean autorizzato = true;
    if(utente!=null)
    	autorizzato &= (utente.getRuolo().equals("admin"));
    	else
    		autorizzato = false;
    if(!autorizzato) {
    	out.clear(); // It clears the output buffer without even letting it write the buffer content to the client.
    	RequestDispatcher rd = application.getRequestDispatcher("/error.jsp");
    	rd.forward(request, response);
    	return;
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risorsa protetta</title>
</head>
<body>
<div>Ciao <%= utente.getNome() %>, sei qui come <%= utente.getRuolo() %> </div>

</body>
</html>