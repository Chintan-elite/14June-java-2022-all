package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/reg")
public class Registrationcontroller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User u = new User();
		u.setUname(uname);
		u.setEmail(email);
		u.setPass(pass);
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		
		if(i>0)
		{
			req.setAttribute("msg", "Registration success !!!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
