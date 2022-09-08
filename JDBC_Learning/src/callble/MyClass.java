package callble;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClass {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/16june","root","");
			
		
			CallableStatement cs = cn.prepareCall("call allemp()");
		    ResultSet rs =   cs.executeQuery();
			 
			 while(rs.next())
			 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			 }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
