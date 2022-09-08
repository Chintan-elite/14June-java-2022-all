package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateEmp {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter email : ");
		String email = sc.next();
		System.out.println("Enter dept : ");
		String dept = sc.next();
		System.out.println("enter sal : ");
		double sal = sc.nextDouble();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/16june","root","");
			
			Statement st = cn.createStatement();
			
			int i =  st.executeUpdate("insert into emp(name,email,dept,sal)values('"+name+"','"+email+"','"+dept+"',"+sal+")");
			if(i>0)
			{
				System.out.println("data inserted...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				
		
		
		
		
	}
}
