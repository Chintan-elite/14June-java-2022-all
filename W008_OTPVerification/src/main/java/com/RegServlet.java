package com;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("email");
		String pass = request.getParameter("pass");
		
		if(email.equals("admin@gmail.com")&&pass.equals("admin"))
		{
			Random rd = new Random();
			int otp =  rd.nextInt(9999);	
			//System.out.println("your otp is : "+otp);
			EmailSending.send(email,otp+"");
			
			ServletContext cx = request.getServletContext();
			cx.setAttribute("myotp", otp);
			
			
			request.getRequestDispatcher("otpverify.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("err", "Invalid email or pass");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	

}
