package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Updatecontroller
 */
@WebServlet("/update")
public class Updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao dao = new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  =response.getWriter();
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		User u = dao.getById(uid);
		Gson gson = new Gson();
		pw.append(gson.toJson(u));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter pw  =response.getWriter();
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		int i = dao.deleteUser(uid);
		if(i>0)
		{
			pw.append("User deleted successfully!!!!");
		}
	}

}
