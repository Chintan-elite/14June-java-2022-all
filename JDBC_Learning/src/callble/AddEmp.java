package callble;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmp {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/16june","root","");
			
		
			CallableStatement cs = cn.prepareCall("call addemp(?,?,?,?,?)");
		   cs.setInt(1, 0);
		   cs.setString(2, "tops");
		   cs.setString(3, "tops@gmial.com");
		   cs.setString(4, "android");
		   cs.setDouble(5, 5000);
		   
		   cs.execute();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
