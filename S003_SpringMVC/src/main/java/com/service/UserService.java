package com.service;

import java.util.ArrayList;

import com.model.User;

public interface UserService {
	
		public void addUser(User u);
		public ArrayList<User> getallUser();
		public User getById(int id);
		public void deleteUser(int id);
}
