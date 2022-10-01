package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname =  req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		PrintWriter pw = resp.getWriter();
		pw.print(uname);
		
		
		
	}
		
}
