package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import model.Book;

@WebServlet("/reg")
public class AddBookcontroller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid  =req.getParameter("uid");
		String bname = req.getParameter("bname");
		String price = req.getParameter("price");
		Book b = new Book();
		b.setBname(bname);
		b.setPrice(Double.parseDouble(price));
		
		BookDao dao = new BookDao();
		if(uid=="" || uid==null)
		{
			boolean valid = dao.isBookExist(b);
			if(valid)
			{
				req.setAttribute("data", dao.getallBook());
				req.setAttribute("err", "book alredy exist");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else
			{
				int i = dao.addBook(b);
				if(i>0)
				{
					req.setAttribute("data", dao.getallBook());
					req.setAttribute("msg", "Book added successfully");
					req.getRequestDispatcher("index.jsp").forward(req, resp);

				}
			}
		}
		else
		{
			b.setBid(Integer.parseInt(uid));
			
				int i = dao.updateBook(b);
				if(i>0)
				{
					req.setAttribute("data", dao.getallBook());
					req.setAttribute("msg", "Book Update successfully");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
			
		}
		
		
		
		
		
	}
}
