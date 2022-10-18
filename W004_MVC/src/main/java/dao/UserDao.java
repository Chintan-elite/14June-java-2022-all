package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDao {
	
	Connection cn;
	public UserDao()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/14june","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addUser(User u)
	{
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into user values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, u.getUname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPass());
			
			 i = ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public boolean logincheck(User u) 
	{
		boolean b = false;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user where email=? and pass=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			
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

	public ArrayList<User> getAllUser() {
		
		ArrayList<User> al = new ArrayList<User>();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				
				al.add(u);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
	}

	public int deleteUser(int did) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from user where id=?");
			ps.setInt(1, did);
			 i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public User getUserById(int uid) {
		
		User u = new User();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from user where id=?");
			ps.setInt(1, uid);
			
			ResultSet rs  =ps.executeQuery();
			
			if(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public int updateUser(User u) {
		
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update user set uname=?, email=?,pass=? where id=?");
			ps.setInt(4, u.getId());
			ps.setString(1, u.getUname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPass());
			
			 i = ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public boolean isEmailExist(User u) {
		boolean b = false;
		try {
	
			PreparedStatement ps = cn.prepareStatement("select * from user where email=?");
			ps.setString(1, u.getEmail());
			
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
