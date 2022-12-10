package com.jdc.mkt.ds;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
	
	
	
}
