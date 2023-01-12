package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Emp;

@Service
public class EmployyeServieImpl implements EmployeeService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void addorUpdateEmployee(Emp e) {
		// TODO Auto-generated method stub
		userDao.addorUpdateEmployee(e);
	}

	@Override
	public List<Emp> viewAllEmp() {
		// TODO Auto-generated method stub
		return userDao.viewAllEmp();
	}

	@Override
	public Emp viewById(int id) {
		// TODO Auto-generated method stub
		return userDao.viewById(id);
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		userDao.deleteEmp(id);
	}

}
