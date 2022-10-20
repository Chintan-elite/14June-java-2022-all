package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;

public class BookDao {
		
	Connection cn;
		public BookDao() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/14june","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public ArrayList<Book> getallBook()
		{
			ArrayList<Book> al = new ArrayList<Book>();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from book");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					Book b = new Book();
					b.setBid(rs.getInt(1));
					b.setBname(rs.getString(2));
					b.setPrice(rs.getDouble(3));
					
					al.add(b);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
		
		public int addBook(Book b)
		{
			int i=0;
			try {
				PreparedStatement ps = cn.prepareStatement("insert into book values(?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, b.getBname());
				ps.setDouble(3, b.getPrice());
				
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		
		public Book getBookById(int id)
		{
			Book b = new Book();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from book where bid=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					
					b.setBid(rs.getInt(1));
					b.setBname(rs.getString(2));
					b.setPrice(rs.getDouble(3));
					
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
		
		public int deleteBook(int id)
		{
			int i=0;
			try {
				PreparedStatement ps = cn.prepareStatement("delete from book where bid=?");
				ps.setInt(1, id);
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		
		
		public int updateBook(Book b)
		{
			int i=0;
			try {
				PreparedStatement ps = cn.prepareStatement("update book set bname=?, price=? where bid=?");
				ps.setInt(3, b.getBid());
				ps.setString(1, b.getBname());
				ps.setDouble(2, b.getPrice());
				
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		
		public boolean isBookExist(Book book)
		{
			boolean b = false;
			try {
				PreparedStatement ps = cn.prepareStatement("select * from book where bname=?");
				ps.setString(1, book.getBname());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					b = true;
				}
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
		
		
}
