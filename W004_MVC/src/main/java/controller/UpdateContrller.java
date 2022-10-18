package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/update")
public class UpdateContrller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid  =Integer.parseInt(req.getParameter("uid"));
		
		UserDao dao = new UserDao();
		User u =  dao.getUserById(uid);
		
		req.setAttribute("user", u);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
}
