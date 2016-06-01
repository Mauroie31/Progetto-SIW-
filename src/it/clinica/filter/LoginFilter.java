package it.clinica.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;



public class LoginFilter implements Filter {
	private ServletContext application;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		/*Vedere i bean e la possibilit� di inserire i vari Controller*/
		if (session.getAttribute("utente")==null) { // questa condizione pu� essere definita meglio
			RequestDispatcher rd  = this.application.getRequestDispatcher("/admin/login.do");
			rd.forward(request, response);	
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {		
		this.application = fConfig.getServletContext();	
	}

	public void destroy() {		
	}
}
