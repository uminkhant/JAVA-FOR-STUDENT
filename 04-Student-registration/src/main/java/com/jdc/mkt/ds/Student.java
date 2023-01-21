package com.jdc.mkt.ds;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private boolean isActive;
	private ClassRoom classRoom;
	private Address address;	
	
	
	
	public Student(String name, String phone, String email,ClassRoom classRoom, Address address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.classRoom = classRoom;
		this.address = address;	
	}



	public Student(Integer id) {
		super();
		this.id = id;
	}
	
	
	
	
	

	
	
	
}
