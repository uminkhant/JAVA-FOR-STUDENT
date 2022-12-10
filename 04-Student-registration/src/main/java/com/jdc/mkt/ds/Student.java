package com.jdc.mkt.ds;

import java.util.List;

public class Student {

	private Integer id;
	private String name;
	private int age;
	private String phone;
	private String email;
	
	private Address address;
	private List<Subject>subjects;

	
	public Student() {
		super();
	}
	
	public Student(Integer id, String name, int age, String phone, String email, Address address,
			List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.subjects = subjects;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
