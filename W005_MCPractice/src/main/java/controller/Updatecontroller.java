package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

/**
 * Servlet implementation class Updatecontroller
 */
@WebServlet("/update")
public class Updatecontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer uid  =Integer.parseInt(req.getParameter("uid"));
		String action = req.getParameter("action");
		BookDao dao = new BookDao();
		if(action.equals("delete"))
		{
			int i = dao.deleteBook(uid);
			if(i>0)
			{
				req.setAttribute("data", dao.getallBook());
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
		else if(action.equals("update"))
		{
			req.setAttribute("user", dao.getBookById(uid));
			req.setAttribute("data", dao.getallBook());
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		
	}

	
}
