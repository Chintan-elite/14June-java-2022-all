package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import model.Student;

public class ViewStudent {
	public static void main(String[] args) {
		
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		List<Student> st =  s.createQuery("from Student").list();
		
		for(Student all : st)
		{
			System.out.println(all.getId()+" "+all.getName()+" "+all.getEmail()+" "+all.getPassword());
		}
		
	}


}
