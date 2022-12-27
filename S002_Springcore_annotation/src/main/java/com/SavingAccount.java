package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SavingAccount implements Account
{
	@Autowired
	@Qualifier("secret")
	User user;
	
	public void getBalnce() {
		
		System.out.println("SavingAccount balance..calling");
		user.basicInfo();
		
	}

}
