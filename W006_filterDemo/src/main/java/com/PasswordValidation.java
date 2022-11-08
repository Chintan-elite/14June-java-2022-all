package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation
{
	
	public static boolean passCheck(String pass) 
	{
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		 
		Matcher matcher = pattern.matcher(pass);
		return  matcher.matches();
		
	}
	 
	
}
