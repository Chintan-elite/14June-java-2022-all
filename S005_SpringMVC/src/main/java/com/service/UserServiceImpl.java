package com.service;

import java.util.List;

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
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}


	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}


	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

}
