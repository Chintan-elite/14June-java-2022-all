package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainclass {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		Account a = context.getBean("savingAccount",Account.class);
		a.getBalnce();
		Account a1 = context.getBean("loan",Account.class);
		a1.getBalnce();
		
		
	
	}
}
