package com;

import java.util.List;
import java.util.Set;

import javax.security.auth.Subject;

public class Student {
	
	int id;
	String name;
	String email;
	List<String> sub; 
	Set<String> lang;
	Address adr;
	
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	public Set<String> getLang() {
		return lang;
	}
	public void setLang(Set<String> lang) {
		this.lang = lang;
	}
	public List<String> getSub() {
		return sub;
	}
	public void setSub(List<String> sub) {
		this.sub = sub;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display()
	{
		System.out.println(id+" "+name+" "+email);
		for(String s : sub)
		{
			System.out.println(s);
		}
		for(String s : lang)
		{
			System.out.println(s);
		}
		adr.dispaly();
	}
	
	
	
	
}
