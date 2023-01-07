package com.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user",user);
		model.addObject("userlist",userService.getAllUser());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/adduser")
	public ModelAndView addUser(@Valid @ModelAttribute("user") User u, BindingResult rs)
	{
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user",user);
		model.addObject("userlist",userService.getAllUser());
		if(rs.hasErrors())
		{
			
			model.setViewName("index");
			
		}
		else
		{
			System.out.println("test3");
			userService.addUser(u);
			model.addObject("msg","Registration successfully !!!");
			model.setViewName("index");
		}
		return model;
	}
	
	@RequestMapping("/delete")
	public String deleteData(@RequestParam("uid") Integer id)
	{
		System.out.println(id);
		userService.deleteUser(id);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public ModelAndView getdatabyid(@RequestParam("uid") Integer id)
	{
		ModelAndView model = new ModelAndView();
		User user = userService.getUserById(id);
		model.addObject("user",user);
		model.addObject("userlist",userService.getAllUser());
		model.setViewName("index");
		return model;
	}
}
