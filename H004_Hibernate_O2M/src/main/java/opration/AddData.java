package opration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;


public class AddData {
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
		
		Category c = s.load(Category.class, 3);
		
		Product p1 = new Product();
		p1.setPname("Makeup");
		p1.setPrice("500");
		p1.setCategory(c);
		
		Product p2 = new Product();
		p2.setPname("Lipstic");
		p2.setPrice("100");
		p2.setCategory(c);
		
		//s.save(c);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		
		
		
	}
}
