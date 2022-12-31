package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class Usercontroller {

	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView();
		User u = new User();
		model.addObject("user", u);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute("user") User u)
	{
		System.out.println(u.getName()+" "+u.getEmail()+" "+u.getPass());
		return "home";
	}
	
	
}
