package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstConnection {
	public static void main(String[] args) {
		
		
		
		try
		{
			//ST:1 Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded !!!");
			
			
			//ST:2 Define connection url
			String url = "jdbc:mysql://localhost:3306/16june";
			String username = "root";
			String password = "";
			
			//ST : 3 Establish connection
			Connection cn =  DriverManager.getConnection(url,username,password);
			System.out.println("connection established");
			
			//ST : 4 create statement
			Statement st = cn.createStatement();
			
			//ST : 5 Execute query
			ResultSet rs = st.executeQuery("select * from emp");
			
			//ST : 6 Process result set
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString("email");
				String dept = rs.getString(4);
				double sal = rs.getDouble(5);
				
				
				System.out.println(id+" "+name+" "+email +" "+dept+" "+sal);
			}
			
		    //	ST :7  clost connection
			cn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
