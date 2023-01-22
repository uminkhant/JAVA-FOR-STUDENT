package com.jdc.mkt.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.ds.Student;
import com.jdc.mkt.service.AttendanceService;
import com.jdc.mkt.service.StudentService;
import com.jdc.mkt.utils.StudentException;

import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class AttendanceServiceImpl implements AttendanceService {

	private StudentService studentService;

	public AttendanceServiceImpl() {
		this.studentService = new StudentServiceImpl();
	}

	@Override
	public void addAttendance(List<Attendance> att) {

		String sql = "insert into attendance_tbl (date,student_id,isPresent,isActive)values(?,?,?,?)";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			
			
			for (Attendance a : att) {
				
				System.out.println("student_id :"+a.getStudent().getId());
				stmt.setDate(1, Date.valueOf(a.getAttDate()));
				stmt.setInt(2, a.getStudent().getId());
				stmt.setBoolean(3, a.isPresent());
				stmt.setBoolean(4, true);
				stmt.executeUpdate();
			}

		} catch (Exception e) {
			throw new StudentException(e.getMessage());
		}

	}

	@Override
	public List<Attendance> getAttendance(int id, String name, String room,LocalDate date) {

		List<Attendance> list = new ArrayList<>();
		List<Object> temp = new ArrayList<>();

		StringBuffer sb = new StringBuffer("""
				select st.id,st.name,cl.id,cl.name,a.id,a.date,a.isPresent from attendance_tbl a
				join student_tbl st on a.student_id=st.id
				join classroom_tbl cl on st.classroom_id=cl.id where a.isActive=1

				""");

		if (id > 0) {
			sb.append(" and a.id=?");
			temp.add(id);
		}

		if (null != name) {
			sb.append(" and st.name=?");
			temp.add(name);

		}
		if (null != room) {
			sb.append(" and cl.name=?");
			temp.add(room);
		}
		
		if(null != date) {
			sb.append(" and a.date=?");
			temp.add(date);
		}

		try (var con = getConnector(); var stmt = con.prepareStatement(sb.toString())) {

			for (int i = 0; i < temp.size(); i++) {
				stmt.setObject(i + 1, temp.get(i));
			}
			var rs = stmt.executeQuery();
			while (rs.next()) {
				Attendance at = new Attendance();
				at.setAttDate(rs.getDate("a.date").toLocalDate());
				at.setStudent(getStudent(rs.getInt("st.id")));
				at.setPresent(rs.getBoolean("a.isPresent"));
				list.add(at);
			}
		} catch (Exception e) {
			throw new StudentException(e.getMessage());
		}
		return list;
	}

	private Student getStudent(int id) {
		return studentService.getStudents(id, null, null).stream().findFirst().orElse(null);
	}

}
