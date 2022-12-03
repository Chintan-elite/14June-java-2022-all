package model;

import jakarta.persistence.*;

@Entity
@Table(name="studentdetails")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sdid")
	int sdid;
	
	@Column(name="address")
	String address;
	
	@OneToOne(mappedBy = "studentDetails",cascade = CascadeType.ALL)
	Student student;

	public int getSdid() {
		return sdid;
	}

	public void setSdid(int sdid) {
		this.sdid = sdid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
