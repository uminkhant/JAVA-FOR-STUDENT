package com.jdc.mkt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.ds.Course;
import com.jdc.mkt.service.CourseService;
import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class CourseServiceImpl implements CourseService {

	@Override
	public void saveCourse(Course course) {
		String sql = "insert into course_tbl (name,description,isActive) values(?,?,?)";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, course.getName());
			stmt.setString(2, course.getDescription());
			stmt.setBoolean(3, course.isActive());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> getCourses(int id, String name) {

		List<Course> list = new ArrayList<>();
		List<Object>tmp = new ArrayList<>();
		StringBuilder sql = new StringBuilder( "select * from course_tbl where isActive=true ");

		if(id > 0) {
			sql.append(" and id=?");
			tmp.add(id);
		}
		
		if(null != name) {
			sql.append(" and name=?");
			tmp.add(name);
		}

		
		try (var con = getConnector(); var stmt = con.prepareStatement(sql.toString())) {

			for(int i = 0 ;i < tmp.size() ;i++) {
				stmt.setObject(i+1, tmp.get(i));
			}
			
			var rs = stmt.executeQuery();

			while (rs.next()) {

				Course c = new Course();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));

				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	

	@Override
	public void updateCourse(Course course) {

		String sql = "update course_tbl set name =?, description=? where id=?";

		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, course.getName());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getId());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCourse(int id) {
		String sql = "update course_tbl set isActive=false where id=?";

		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
