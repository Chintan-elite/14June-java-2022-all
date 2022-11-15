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
				PreparedStatement ps = cn.prepareStatement("insert into user(uid,uname,email,pass,dob,country) values(?,?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, u.getUname());
				ps.setString(3, u.getEmail());
				ps.setString(4, u.getPass());
				ps.setString(5, u.getDob());
				ps.setString(6, u.getCountry());
				
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

		public int deleteUser(Integer uid) {
			int i=0;
			PreparedStatement ps;
			try {
				ps = cn.prepareStatement("delete from user where uid=?");
				ps.setInt(1, uid);
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return i;
		}

		public User getById(Integer uid) {
			
			User u = new User();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from user where uid=?");
				ps.setInt(1, uid);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					u.setId(rs.getInt(1));
					u.setUname(rs.getString("uname"));
					u.setEmail(rs.getString("email"));
					u.setPass(rs.getString("pass"));
					u.setCountry(rs.getString("country"));
					u.setDob(rs.getString("dob"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return u;
		}

		public int updateUser(User u) {
			
			int i=0;
			try {
				PreparedStatement ps = cn.prepareStatement("update user set uname=?,email=?,pass=?,dob=?,country=? where uid=?");
				ps.setInt(6 , u.getId());
				ps.setString(1, u.getUname());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getPass());
				ps.setString(4, u.getDob());
				ps.setString(5, u.getCountry());
				
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
			
		}

		public ArrayList<User> searchUser(String value)
		{
			ArrayList<User> al = new ArrayList();
			try {
				PreparedStatement ps = cn.prepareStatement("select * from user where uname like ?");
				ps.setString(1, value+"%");
				
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
