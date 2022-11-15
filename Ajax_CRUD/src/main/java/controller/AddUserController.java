package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/reg")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  =response.getWriter();
		User u = new User();
		u.setId(Integer.parseInt(req.getParameter("uid")));
		u.setUname(req.getParameter("uname"));
		u.setEmail(req.getParameter("email"));
		u.setPass(req.getParameter("pass"));
		u.setDob(req.getParameter("dob"));
		u.setCountry(req.getParameter("country"));
		
		UserDao dao = new UserDao();
		int i = dao.updateUser(u);
		
		if(i>0)
		{
			pw.append("User Updated successfully");
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  =response.getWriter();
		User u = new User();
		u.setUname(req.getParameter("uname"));
		u.setEmail(req.getParameter("email"));
		u.setPass(req.getParameter("pass"));
		u.setDob(req.getParameter("dob"));
		
		u.setCountry(req.getParameter("country"));
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		
		if(i>0)
		{
			pw.append("UserAdded successfully");
		}
		
		
	}

}
