package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/login")
public class Logincontroller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User u = new User();
		u.setEmail(email);
		u.setPass(pass);
		
		UserDao dao = new UserDao();
		boolean i = dao.logincheck(u);
		
		if(i)
		{
			req.setAttribute("msg", email);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
	
		}
		else
		{
			req.setAttribute("msg", "Invalid username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
