package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
	public void addUser(User u);
	public List<User> getAllUser();
	public User getUserById(int id);
	public void deleteUser(int id);
	
}
