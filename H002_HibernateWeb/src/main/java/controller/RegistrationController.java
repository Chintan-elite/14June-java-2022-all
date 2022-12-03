package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		Student st = new Student();
		if(!id.equals(""))
		{
			st.setId(Integer.parseInt(id));
		}
		st.setName(name);
		st.setEmail(email);
		st.setPassword(pass);
		
		StudentDao std = new StudentDao();
		std.addStudent(st);
		
	}

}
