package opration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;
import model.StudentDetails;

public class ViewData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.addAnnotatedClass(StudentDetails.class)
							.buildSessionFactory();
		
		
		Session s  =sf.openSession();
		
		s.beginTransaction();
		
		
//		 List<Student> std =  s.createQuery("from Student").list();
//		 for(Student st : std)
//		 {
//			 System.out.println(st.getId()+" "+st.getName()+" "+st.getEmail());
//			 System.out.println(st.getStudentDetails().getAddress());
//		 }
		
		
		
//		 Student st =s.load(Student.class, 1);
//		 System.out.println(st.getId()+" "+st.getName()+" "+st.getEmail());
//		 System.out.println(st.getStudentDetails().getAddress());
//		
		
		StudentDetails st = s.load(StudentDetails.class,1);
		System.out.println(st.getAddress());
		System.out.println(st.getStudent().getName()+" "+st.getStudent().getEmail());
	}
}
