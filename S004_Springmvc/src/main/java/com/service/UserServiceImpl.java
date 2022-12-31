package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void addUser(User u) {
		userDao.addUser(u);
	}

	@Override
	public ArrayList<User> getallUser() {
		// TODO Auto-generated method stub
		return userDao.getallUser();
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

}
