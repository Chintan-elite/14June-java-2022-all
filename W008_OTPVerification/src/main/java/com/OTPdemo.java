package com;

import java.util.Random;

public class OTPdemo {
	public static void main(String[] args) {
		
		
		Random rd = new Random();
		int otp =  rd.nextInt(9999);	
		System.out.println(otp);
	}
}
