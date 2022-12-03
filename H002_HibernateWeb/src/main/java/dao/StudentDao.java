package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class StudentDao {
	
		SessionFactory sf;
		public StudentDao() {
			
			Configuration cfg = new Configuration();
			cfg.configure("resource/hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);
			sf = cfg.buildSessionFactory();
		}
		
		public void addStudent(Student st)
		{
			Session s  =sf.openSession();
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(st);
			tx.commit();
		}
		
		public List<Student> allStudent()
		{
			Session s  =sf.openSession();
			Transaction tx = s.beginTransaction();
			return s.createQuery("from Student").list();
		}
		
		public Student getById(int id)
		{
			Session s  =sf.openSession();
			Transaction tx = s.beginTransaction();
			return s.get(Student.class, id);
		}
		
		public void deleteStudent(int id)
		{
			Session s  =sf.openSession();
			Transaction tx = s.beginTransaction();
			Student std = s.get(Student.class, id);
			s.delete(std);
			tx.commit();
		}
}
