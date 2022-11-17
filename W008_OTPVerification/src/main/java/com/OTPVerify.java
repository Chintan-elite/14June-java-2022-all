package com;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OTPVerify
 */
@WebServlet("/otp")
public class OTPVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int otp =Integer.parseInt(request.getParameter("otp"));
		ServletContext cx  =request.getServletContext();
		int myotp =  (int) cx.getAttribute("myotp");
		
		if(otp==myotp)
		{
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("err", "Invalid otp");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		
	}

	

}
