package com;

import org.springframework.stereotype.Component;

@Component("personal")
public class PersonalInfo implements User {

	public void basicInfo() {
		
		System.out.println("user basic info for saving account");

	}

}
