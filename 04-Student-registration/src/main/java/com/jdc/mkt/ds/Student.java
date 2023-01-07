package com.jdc.mkt.ds;


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
	
	
	public Student() {
		super();
	}
	
	
	
	
}
