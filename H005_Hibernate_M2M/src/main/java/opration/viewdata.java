package opration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Faculty;
import com.Subject;


public class viewdata {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Faculty.class)
							.addAnnotatedClass(Subject.class)
							.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		
		List<Faculty> all = s.createQuery("from Faculty where fname='Rahul'").list();
		
		for(Faculty f:all)
		{
			System.out.println(f.getFname());
			System.out.println("*****************");
			for(Subject sub : f.getSubject())
			{
				System.out.println(sub.getSub_name());
			}
		}
			
		
		
		
	}
}
