package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/14june","root","root");
		
			PreparedStatement ps = cn.prepareStatement("select * from user where uname=? and pass=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				req.setAttribute("uname", rs.getString(2));
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				
			}
			else
			{
				req.setAttribute("err", "Invalid username or pass");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
