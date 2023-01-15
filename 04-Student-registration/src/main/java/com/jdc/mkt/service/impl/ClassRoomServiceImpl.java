package com.jdc.mkt.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.service.ClassRoomService;

import jakarta.annotation.Resource;

import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class ClassRoomServiceImpl implements ClassRoomService {

	@Resource(name = "jdbc/student")
	private DataSource ds;
	
	@Override
	public void saveClassRoom(ClassRoom classroom) {
		
		String sql = "insert into classroom_tbl (name,duration,st_date,end_date)values(?,?,?,?)";
		try(var con = getConnector();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, classroom.getName());
			stmt.setInt(2, classroom.getDurations());
			stmt.setDate(3, Date.valueOf(classroom.getStartDate()));
			stmt.setDate(4, Date.valueOf(classroom.getEndDate()));
			
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ClassRoom> getClassRooms() {
		// TODO Auto-generated method stub
		return null;
	}

}
