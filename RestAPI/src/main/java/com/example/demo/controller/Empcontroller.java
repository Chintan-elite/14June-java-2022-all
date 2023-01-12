package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class Empcontroller {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public String addUser(@RequestBody Emp e)
	{
		employeeService.addorUpdateEmployee(e);
		return "Data inserted";
	}
	
	@GetMapping("/")
	public List<Emp> viewData()
	{
		return employeeService.viewAllEmp();
	}
	
	@GetMapping("/{eid}")
	public Emp viewbyidData(@PathVariable("eid") int id)
	{
		System.out.println(id);
		return employeeService.viewById(id);
	}
	
	@PutMapping("/{eid}")
	public String updateEmp(@RequestBody Emp e, @PathVariable("eid") int id)
	{
		e.setId(id);
		employeeService.addorUpdateEmployee(e);
		return "data updated";
	}
	
	@DeleteMapping("/{eid}")
	public String deleteEmp(@PathVariable("eid") int id)
	{
		employeeService.deleteEmp(id);
		return "delet calling callin..";
	}
}
