package com;

import java.util.ArrayList;
import java.util.List;import org.hibernate.boot.model.source.spi.ColumnBindingDefaults;

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
@Table(name="subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	int sid;
	
	@Column(name="s_name")
	String sub_name;
	
	@ManyToMany
	@JoinTable(
			name="faculty_subject",
			joinColumns = @JoinColumn(name="sid"),
			inverseJoinColumns = @JoinColumn(name="fid")
			)
	List<Faculty> faculty;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}
	
	public void addFaculty(Faculty f)
	{
		if(faculty==null)
		{
			faculty = new ArrayList<Faculty>();
		}
		faculty.add(f);
	}
	
	
}
