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
	//SessionFactory sessionFactory;

	@Override
	public void addUser(User u) {
//		
//		Session s = sessionFactory.openSession();
//		Transaction tx = s.beginTransaction();
//		s.save(u);
//		tx.commit();
	}

	@Override
	public ArrayList<User> getallUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
