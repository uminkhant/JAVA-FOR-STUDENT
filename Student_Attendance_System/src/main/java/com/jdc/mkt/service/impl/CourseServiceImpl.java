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
		String sql = "insert into course_tbl (name,description,fees,isActive,classroom_id) values(?,?,?,?,?)";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, course.getName());
			stmt.setString(2, course.getDescription());
			stmt.setInt(3, course.getFees());
			stmt.setBoolean(4, course.isActive());
			stmt.setInt(5, course.getClassRoom().getId());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> getCourses() {

		List<Course> list = new ArrayList<>();

		String sql = "select c.id,c.name,c.description,c.fees,cl.id,cl.name,cl.duration,cl.st_date,cl.end_date from course_tbl c "
				+ "join classroom_tbl cl on c.classroom_id = cl.id" + " where c.isActive=true";

		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			var rs = stmt.executeQuery();

			while (rs.next()) {

				ClassRoom cr = new ClassRoom();
				cr.setId(rs.getInt("cl.id"));
				cr.setName(rs.getString("cl.name"));
				cr.setDurations(rs.getInt("cl.duration"));
				cr.setStartDate(rs.getDate("cl.st_date").toLocalDate());
				cr.setStartDate(rs.getDate("cl.end_date").toLocalDate());

				Course c = new Course();
				c.setId(rs.getInt("c.id"));
				c.setName(rs.getString("c.name"));
				c.setDescription(rs.getString("c.description"));
				c.setFees(rs.getInt("c.fees"));
				c.setClassRoom(cr);

				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateCourse(Course course) {

		String sql ="update course_tbl set description=?,fees=? , isActive=? where id=?";
		
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {
		
			stmt.setString(1, course.getDescription());
			stmt.setInt(2, course.getFees());
			stmt.setBoolean(3, course.isActive());
			stmt.setInt(4, course.getId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
