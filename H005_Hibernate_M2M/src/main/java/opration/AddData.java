package opration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Faculty;
import com.Subject;


public class AddData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Faculty.class)
							.addAnnotatedClass(Subject.class)
							.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
//		Faculty f1 = new Faculty();
//		f1.setFname("Rahul");
//		
//		Subject s1 = new Subject();
//		s1.setSub_name("java");
//		s1.addFaculty(f1);
//		
//		Subject s2 = new Subject();
//		s2.setSub_name("Android");
//		s2.addFaculty(f1);
//		
//		s.save(f1);
//		s.save(s1);
//		s.save(s2);
		
//		Subject s1 = s.load(Subject.class, 2);
//		
//		Faculty f1 = new Faculty();
//		f1.setFname("Priti");
//		f1.addSubject(s1);
//		
//		s.save(f1);
		
		Faculty f1 = s.load(Faculty.class, 2);
		
		Subject s1 = new Subject();
		s1.setSub_name("ios");
		s1.addFaculty(f1);
		
		s.save(s1);
		
		tx.commit();
		
		
		
	}
}
