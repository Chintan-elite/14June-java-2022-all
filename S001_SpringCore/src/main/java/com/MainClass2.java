package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext2.xml");
		
		Employee emp =context.getBean(Employee.class,"emp");
		emp.display();
		
		
	}
}
