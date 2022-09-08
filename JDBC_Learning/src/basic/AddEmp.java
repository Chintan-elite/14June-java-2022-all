package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddEmp {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id : ");
		int id = sc.nextInt();
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
			
			int i =  st.executeUpdate("update emp set name='"+name+"',email='"+email+"',dept = '"+dept+"',sal="+sal+" where id="+id+"");
			if(i>0)
			{
				System.out.println("data updated...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				
		
		
		
		
	}
}
