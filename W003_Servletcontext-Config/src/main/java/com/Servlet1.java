package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Welcome Servlet1</h1>");
		
		ServletContext cx = req.getServletContext();
		String driver =  cx.getInitParameter("driver");
		String url = cx.getInitParameter("url");
		pw.write("<h1>driver  : "+driver+"</h1>");
		pw.write("<h1>url  : "+url+"</h1>");
		
		
		ServletConfig cf =getServletConfig();
		String path = cf.getInitParameter("path");
		pw.write("<h1>Path is : "+path+"</h1>");
		
		
	}
}
