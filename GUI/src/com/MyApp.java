package com;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyApp {
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setTitle("Demo");
		//frame.setResizable(false);
		frame.setLayout(null);
	
		
		JLabel title = new JLabel("Registration form");
		title.setBounds(130,20,200,50);
		
		JLabel uname = new JLabel("username");
		uname.setBounds(70,80,80,20);
		JTextField unameT = new JTextField();
		unameT.setBounds(160,80,150,20);
		
		JLabel email = new JLabel("Email");
		email.setBounds(70,110,80,20);
		JTextField emailT = new JTextField();
		emailT.setBounds(160,110,150,20);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(70,140,80,20);
		JPasswordField passT = new JPasswordField();
		passT.setBounds(160,140,150,20);
		
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(70,170,80,20);
		JRadioButton btn1 = new JRadioButton("Male");
		JRadioButton btn2 = new JRadioButton("Female");
		btn1.setBounds(160,170,70,20);
		btn2.setBounds(230,170,70,20);
		ButtonGroup btn = new ButtonGroup();
		btn.add(btn1);
		btn.add(btn2);
		


		JLabel lang = new JLabel("Languages");
		lang.setBounds(70,200,80,20);
		JCheckBox c1 = new JCheckBox("Gujarati");
		JCheckBox c2 = new JCheckBox("English");
		JCheckBox c3 = new JCheckBox("Hindi");
		JCheckBox c4 = new JCheckBox("Marathi");
		c1.setBounds(160,200,70,20);
		c2.setBounds(230,200,70,20);
		c3.setBounds(160,230,70,20);
		c4.setBounds(230,230,70,20);
		
		String allCountry[] = {"India","Usa","canada","uk"};
		JLabel country = new JLabel("country");
		country.setBounds(70,260,80,20);
		JComboBox<String> ct = new JComboBox<>(allCountry);
		ct.setBounds(160,260,150,20);
		
		
		frame.add(title);
		frame.add(uname);
		frame.add(unameT);
		frame.add(email);
		frame.add(emailT);
		frame.add(pass);
		frame.add(passT);
		frame.add(gender);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(lang);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
		frame.add(c4);
		frame.add(country);
		frame.add(ct);
		
	}
}
