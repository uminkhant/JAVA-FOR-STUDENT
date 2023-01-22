package com.jdc.mkt.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.ds.Attendance;

public interface AttendanceService {

	public void addAttendance(List<Attendance> att);
	public List<Attendance>getAttendance(int id,String name,String room,LocalDate date);
	
}
