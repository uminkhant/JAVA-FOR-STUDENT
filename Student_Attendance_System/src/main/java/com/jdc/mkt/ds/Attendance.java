package com.jdc.mkt.ds;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Attendance {

	private int id;
	private LocalDate attDate;
	private boolean isPresent;
	private Student student;
	private boolean isActive;
	

	public Attendance() {
		super();
	}


	public Attendance(LocalDate attDate, boolean isPresent, Student student, boolean isActive) {
		super();
		this.attDate = attDate;
		this.isPresent = isPresent;
		this.student = student;
		this.isActive = isActive;
	}
	
	
	
}
