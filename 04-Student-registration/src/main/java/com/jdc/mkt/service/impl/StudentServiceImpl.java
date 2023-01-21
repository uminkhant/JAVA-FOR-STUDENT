package com.jdc.mkt.service.impl;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jdc.mkt.ds.Address;
import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.ds.Student;
import com.jdc.mkt.service.StudentService;
import com.jdc.mkt.utils.StudentException;

import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class StudentServiceImpl implements StudentService {

	@Override
	public void saveStudent(Student st) {
		String sql = "insert into student_tbl(name,email,phone,isActive,classroom_id,address_id)values(?,?,?,?,?,?)";
		
	int address_id =  saveAndGetId(st.getAddress().getStreet(), st.getAddress().getTownship(),
				st.getAddress().getCity());
		
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, st.getName());
			stmt.setString(2, st.getEmail());
			stmt.setString(3, st.getPhone());		
			stmt.setBoolean(4, true);
			stmt.setInt(5, st.getClassRoom().getId());	
			stmt.setInt(6,address_id);

			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new StudentException("saveStudent db error.");
		}

	}

	private int saveAndGetId(String street, String township, String city) {

		String sql = "insert into address_tbl(street,city,township)values(?,?,?)";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, street);
			stmt.setString(2, city);
			stmt.setString(3, township);
			
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			throw new StudentException("saveAddress db error.");
		}
		return 0;
	}

	@Override
	public List<Student> getStudents(int id,String name,String room) {
		StringBuffer sb =new StringBuffer("""
				select st.id,st.name,st.email,st.phone,
				cl.id,cl.name,cl.duration,cl.st_date,cl.end_date,
				ad.id,ad.city,ad.township,ad.street
				from student_tbl st 
				join address_tbl ad on st.address_id = ad.id
				join classroom_tbl cl on st.classroom_id= cl.id
				where st.isActive = true 
				""");
		List<Object> temp = new ArrayList<>();
		List<Student>list = new ArrayList<>();
		
		
		if(id>0) {
			sb.append(" and st.id=?");
			temp.add(id);
		}
		
		if(null != name) {
			sb.append(" and st.name=?");
			temp.add(name);
		}
		
		if(null != room) {
			sb.append(" and cl.name=?");
			temp.add(room);
		}

		try (var con = getConnector(); var stmt = con.prepareStatement(sb.toString())) {

			for(int i = 0 ; i < temp.size() ; i++) {
				stmt.setObject(i+1, temp.get(i));
			}
			
			var rs = stmt.executeQuery();

			while (rs.next()) {
				
				Address ad = new Address();
				ad.setId(rs.getInt("ad.id"));
				ad.setCity(rs.getString("ad.city"));
				ad.setTownship(rs.getString("ad.township"));
				ad.setStreet(rs.getString("ad.street"));
				
				ClassRoom cr = new ClassRoom();
				cr.setId(rs.getInt("cl.id"));
				cr.setName(rs.getString("cl.name"));
				cr.setDurations(rs.getInt("cl.duration"));
				cr.setStartDate(rs.getDate("st_date").toLocalDate());
				cr.setStartDate(rs.getDate("st_date").toLocalDate());
				

				Student st = new Student(
						
								rs.getString("st.name"),
								rs.getString("st.phone"), 
								rs.getString("st.email"),
								cr,
								ad);
				st.setId(rs.getInt("st.id"));

				list.add(st);
			}

		} catch (Exception e) {
			throw new StudentException("getStudents db error.");
		}
		return list;
	}

	

}
