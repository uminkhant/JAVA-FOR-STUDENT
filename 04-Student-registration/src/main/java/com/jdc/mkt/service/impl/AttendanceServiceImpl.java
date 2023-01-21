package com.jdc.mkt.service.impl;

import java.util.List;

import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.service.AttendanceService;
import com.jdc.mkt.service.StudentService;

public class AttendanceServiceImpl implements AttendanceService{
	
	private StudentService studentService;
	
	

	public AttendanceServiceImpl() {
		this.studentService = new StudentServiceImpl();
	}

	@Override
	public void addAttendance(Attendance att) {
		
		
	}

	@Override
	public List<Attendance> getAttendance() {
		return null;
	}

	
	

}
