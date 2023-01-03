package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUser(User u) {

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(u);
		tx.commit();
		System.out.println("data inserted..");
		
	}
	

	@Override
	public ArrayList<User> getallUser() {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		return (ArrayList<User>) s.createQuery("from User").list();
		
	}

	@Override
	public User getById(int id) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		return s.load(User.class, id);
	}

	@Override
	public void deleteUser(int id) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		User u=  s.get(User.class, id);
		s.delete(u);
		tx.commit();
	}
	
}
