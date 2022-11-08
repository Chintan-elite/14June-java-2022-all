package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RegFilter
 */
@WebFilter("/reg")
public class RegFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		RequestDispatcher rd  = request.getRequestDispatcher("reg.jsp");
		if(uname.equals("") || uname.equals(null))
		{
			request.setAttribute("unameErr", "Username can not be blank");
			rd.forward(request, response);
		}
		
		
		if(email.equals("") || email.equals(null))
		{
			request.setAttribute("emailErr", "email can not be blank");
			rd.forward(request, response);
		}
		else if(!EmailValidation.emailCheck(email))
		{
			request.setAttribute("emailErr", "Invalid format");
			rd.forward(request, response);
		}
		
		if(pass.equals("") || pass.equals(null))
		{
			request.setAttribute("passErr", "pass can not be blank");
			rd.forward(request, response);
		}
		else if(!PasswordValidation.passCheck(pass))
		{
			request.setAttribute("passErr", "Invalid format");
			rd.forward(request, response);
		}
			
		
		
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
