package opration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;
import model.StudentDetails;

public class AddData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.addAnnotatedClass(StudentDetails.class)
							.buildSessionFactory();
		
		StudentDetails sd = new StudentDetails();
		sd.setAddress("baroda");
		
		
		Student std = new Student();
		std.setName("Priti");
		std.setEmail("priti@gmail.com");
		std.setStudentDetails(sd);
		
		Session s  =sf.openSession();
		Transaction tx = s.beginTransaction();
		//s.save(sd);
		s.save(std);
		
		tx.commit();
		
		
	}
}
