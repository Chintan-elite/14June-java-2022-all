package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDao {
		
		Connection cn = null;
		public UserDao() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywork","root","root");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		public int addUser(User u)
		{
			int i=0;
			try {
				PreparedStatement ps = cn.prepareStatement("insert into user(uid,uname,email,pass,country) values(?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, u.getUname());
				ps.setString(3, u.getEmail());
				ps.setString(4, u.getPass());
				ps.setString(5, u.getCountry());
				
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
					
		}
		
		
		public ArrayList<User> getAllUser()
		{
			ArrayList<User> al = new ArrayList();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from user");
			
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					User u = new User();
					u.setId(rs.getInt(1));
					u.setUname(rs.getString("uname"));
					u.setEmail(rs.getString("email"));
					u.setPass(rs.getString("pass"));
					u.setCountry(rs.getString("country"));
					u.setDob(rs.getString("dob"));
					
					al.add(u);
				}
					
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
		
		
}
