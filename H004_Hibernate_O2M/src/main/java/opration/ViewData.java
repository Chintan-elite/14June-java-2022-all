package opration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;


public class ViewData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Category.class)
							.addAnnotatedClass(Product.class)
							.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		List<Category> cats = s.createQuery("from Category").list();
		for(Category c : cats)
		{
			System.out.println(c.getCatName());
			for(Product p : c.getProducts())
			{
				System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice());
			}
		}
		
		
	}
}
