package com.hibernate.learn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int identifier;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="City")
	private String city;
	
	@Column(name="Contact_Number")
	private int contactNumber;
	
	@Column(name="Email")
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(fetch=FetchType.LAZY,
				mappedBy="instructor", 
				cascade= {CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Instructor() {
	
	}

	public Instructor(String name, String address, String city, int contactNumber, String email) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void add(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(course);
		course.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor [identifier=" + identifier + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
}
