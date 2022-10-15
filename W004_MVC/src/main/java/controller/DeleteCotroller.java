package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/delete")
public class DeleteCotroller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int did =Integer.parseInt(req.getParameter("did"));
		
		
		UserDao dao = new UserDao();
		int i = dao.deleteUser(did);
		
		if(i>0)
		{
			req.getRequestDispatcher("display").forward(req, resp);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
