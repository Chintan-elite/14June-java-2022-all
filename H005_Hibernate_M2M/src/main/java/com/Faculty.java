package com;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fid")
	int fid;
	
	@Column(name="fname")
	String fname;
	
	@ManyToMany
	@JoinTable(
			name="faculty_subject",
			joinColumns = @JoinColumn(name="fid"),
			inverseJoinColumns = @JoinColumn(name="sid")
			)
	List<Subject> subject;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	public void addSubject(Subject s)
	{
		if(subject == null)
		{
			subject = new ArrayList<Subject>();
		}
		subject.add(s);
	}
	
}
