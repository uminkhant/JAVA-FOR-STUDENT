package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.ds.Course;

public interface CourseService {

	void saveCourse(Course course);
	List<Course>getCourses(String name);
	void deleteCourse(int id);
}
