package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

/**
 * Servlet implementation class ViewBookcontroller
 */
@WebServlet("/display")
public class ViewBookcontroller extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookDao dao = new BookDao();
		req.setAttribute("data", dao.getallBook());
		req.getRequestDispatcher("index.jsp").forward(req, resp);

		
	}

	

}
