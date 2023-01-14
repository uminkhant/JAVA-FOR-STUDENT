package com.jdc.mkt.service.impl;

import java.sql.Connection;
import java.util.List;

import com.jdc.mkt.ds.Course;
import com.jdc.mkt.service.CourseService;
import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class CourseServiceImpl implements CourseService{	
	
	@Override
	public void saveCourse(Course course) {
		String sql = "insert into course_tbl (name,description,fees,classroom_id) values(?,?,?,?)";
		try(var con = getConnector();
				var stmt = con.prepareStatement(sql)){
		
		}catch (Exception e) {
			
		}
	}

	@Override
	public List<Course> getCourses(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		
	}

}
