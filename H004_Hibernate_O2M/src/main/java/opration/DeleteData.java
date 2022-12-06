package opration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;


public class DeleteData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Category.class)
							.addAnnotatedClass(Product.class)
							.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//Category c = new Category();
		//c.setCatName("Cosmetic");
		
		//Category c = s.load(Category.class, 3);
		//s.delete(c);
		
		Product p = s.load(Product.class, 3);
		s.delete(p);
		tx.commit();
		
		
		
	}
}
