package com.jdc.mkt.utils;

import com.jdc.mkt.service.ClassRoomService;
import com.jdc.mkt.service.StudentService;
import com.jdc.mkt.service.impl.ClassRoomServiceImpl;
import com.jdc.mkt.service.impl.StudentServiceImpl;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class StudentListener implements ServletRequestListener {

	private ClassRoomService classRoomService;
	private StudentService studentService;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		classRoomService = new ClassRoomServiceImpl();
		studentService = new StudentServiceImpl();
		
		sre.getServletContext().setAttribute("students", studentService.getStudents(0, null, null));
		sre.getServletContext().setAttribute("classrooms", classRoomService.getClassRooms(0, null));
		
	}

}
