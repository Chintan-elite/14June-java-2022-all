package basic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class MetadtaDemo {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/16june","root","");
			
			DatabaseMetaData mdata = cn.getMetaData();
			System.out.println(mdata.getDatabaseProductVersion());
			System.out.println(mdata.getDriverMajorVersion());
			System.out.println(mdata.getDatabaseProductName());
			
			PreparedStatement ps = cn.prepareStatement("select * from library");
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rdata = rs.getMetaData();
			System.out.println(rdata.getColumnCount());
			System.out.println(rdata.getColumnName(2));
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
