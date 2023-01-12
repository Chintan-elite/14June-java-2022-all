package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Emp;

public interface UserDao {
	
	public void addorUpdateEmployee(Emp e);
	public List<Emp> viewAllEmp();
	public Emp viewById(int id);
	public void deleteEmp(int id);
}
