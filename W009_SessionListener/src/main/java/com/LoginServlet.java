package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  =response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		if(email.equals("admin") && pass.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			ServletContext cx = request.getServletContext();
			int currentuser =  (int) cx.getAttribute("cu");
			int totaluser =  (int) cx.getAttribute("tu");
			pw.print("<h1>current user : "+currentuser+"</h1>");
			pw.print("<h1>totaluser  : "+totaluser+"</h1>");
			pw.print("<a href='logout'>Logout</a>");
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	

}
