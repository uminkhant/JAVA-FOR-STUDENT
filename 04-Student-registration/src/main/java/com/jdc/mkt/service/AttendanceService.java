package com.jdc.mkt.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.ds.ClassRoom;

public interface AttendanceService {

	public void addAttendance(Attendance att);
	public List<Attendance>getAttendance();
	
}
