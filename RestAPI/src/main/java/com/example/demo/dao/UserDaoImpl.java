package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;
import com.example.demo.repo.EmpRepo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	EmpRepo empRepo;
	
	@Override
	public void addorUpdateEmployee(Emp e) {
		// TODO Auto-generated method stub
		empRepo.save(e);
	}

	@Override
	public List<Emp> viewAllEmp() {
		
		return empRepo.findAll();
	}

	@Override
	public Emp viewById(int id) {
		
		List<Emp> empall = empRepo.findAll();
		for(int i=0;i<empall.size();i++)
		{
			Emp temp = empall.get(i);
			if(temp.getId()==id)
			{
				return temp;
			}
		}
		return null;
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
		
	}

}
