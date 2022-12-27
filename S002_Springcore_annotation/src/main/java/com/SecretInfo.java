package com;

import org.springframework.stereotype.Component;

@Component("secret")
public class SecretInfo implements User {

	public void basicInfo() {
		
		System.out.println("this is secret info for saving account");
	}

}
