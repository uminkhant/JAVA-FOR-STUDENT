package com.jdc.mkt.ds;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Attendance {

	private int id;
	private LocalDate attDate;
	private boolean isAbsent;
	private ClassRoom classRoom;
	private Student student;
	
	

	public Attendance(ClassRoom classRoom, Student student, LocalDate attDate,boolean isAbsent) {
		super();
		this.classRoom = classRoom;
		this.student = student;
		this.attDate = attDate;
		this.isAbsent = isAbsent;
	}



	public Attendance() {
		super();
	}
	
	
	
}
