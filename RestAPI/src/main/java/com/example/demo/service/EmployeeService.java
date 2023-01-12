package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Emp;

public interface EmployeeService {
	
	public void addorUpdateEmployee(Emp e);
	public List<Emp> viewAllEmp();
	public Emp viewById(int id);
	public void deleteEmp(int id);
}
