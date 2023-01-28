package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.ds.Course;

public interface CourseService {

	void saveCourse(Course course);
	List<Course>getCourses(int id,String name);
	void updateCourse(Course course);
	void deleteCourse(int id);
	
}
