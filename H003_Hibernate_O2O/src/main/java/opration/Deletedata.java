package opration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;
import model.StudentDetails;

public class Deletedata {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.addAnnotatedClass(StudentDetails.class)
							.buildSessionFactory();
		
		
		
		
		
		Session s  =sf.openSession();
		Transaction tx = s.beginTransaction();
		Student st = s.load(Student.class, 1);
		s.delete(st);
		tx.commit();
		
		
	}
}
