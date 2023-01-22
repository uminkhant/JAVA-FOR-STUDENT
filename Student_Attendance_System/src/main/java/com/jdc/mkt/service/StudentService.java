package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.ds.Student;

public interface StudentService {
	
	void saveStudent(Student st);
	List<Student>getStudents(int id,String name,String room);
	

}
