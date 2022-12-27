package com;

import org.springframework.stereotype.Component;

@Component("loan")
public class LoanAccount implements Account
{

	public void getBalnce() {
		
		System.out.println("loan account balance calling...");
		
	}

}
