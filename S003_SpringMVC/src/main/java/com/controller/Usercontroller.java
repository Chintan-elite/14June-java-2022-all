package com.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserService;

@Controller
public class Usercontroller {

	@Autowired
	UserService userService;
	
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
	public ModelAndView addUser(@ModelAttribute("user") User u)
	{
		//System.out.println(u.getName()+" "+u.getEmail()+" "+u.getPass());
		userService.addUser(u);
		ModelAndView model = new ModelAndView();
		model.addObject("data",userService.getallUser());
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping("/view")
	public ModelAndView alluser()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("data",userService.getallUser());
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping("/delete/{did}")
	public ModelAndView deleteUser(@PathVariable(value="did") Integer id)
	{
		ModelAndView model = new ModelAndView();
		userService.deleteUser(id);
		model.addObject("data",userService.getallUser());
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping("/update/{uid}")
	public ModelAndView getUserbyid(@PathVariable(value="uid") Integer id)
	{
		
		ModelAndView model = new ModelAndView();
		User u =  userService.getById(id);
		model.addObject("user", u);
		model.setViewName("index");
		return model;
		
	}
	
}
