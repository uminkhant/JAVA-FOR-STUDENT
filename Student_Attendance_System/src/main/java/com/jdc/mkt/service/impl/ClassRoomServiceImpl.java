package com.jdc.mkt.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.service.ClassRoomService;
import com.jdc.mkt.utils.StudentException;

import static com.jdc.mkt.utils.ConnectionManager.getConnector;

public class ClassRoomServiceImpl implements ClassRoomService {

	@Override
	public void saveClassRoom(ClassRoom classroom) {

		String sql = "insert into classroom_tbl (name,fees,duration,st_date,end_date,isActive)values(?,?,?,?,?,?)";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, classroom.getName());
			stmt.setInt(2, classroom.getFees());
			stmt.setInt(3, classroom.getDurations());

			stmt.setDate(4, Date.valueOf(classroom.getStartDate()));
			stmt.setDate(5, Date.valueOf(classroom.getEndDate()));
			stmt.setBoolean(6, classroom.isActive());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new StudentException("classroom saveClassRoom to db error.");
		}

	}

	@Override
	public List<ClassRoom> getClassRooms(int id, String name) {

		List<Object> temp = new ArrayList<>();
		List<ClassRoom> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer("select * from classroom_tbl where isActive=true");

		if (id > 0) {
			sb.append(" and id=?");
			temp.add(id);
		}

		if (null != name) {
			sb.append(" and name=?");
			temp.add(name);
		}

		try (var con = getConnector(); var stmt = con.prepareStatement(sb.toString())) {

			for (int i = 0; i < temp.size(); i++) {
				stmt.setObject(i + 1, temp.get(i));
			}

			var rs = stmt.executeQuery();

			while (rs.next()) {
				ClassRoom cr = new ClassRoom();

				cr.setId(rs.getInt("id"));
				cr.setName(rs.getString("name"));
				cr.setFees(rs.getInt("fees"));
				cr.setDurations(rs.getInt("duration"));
				cr.setStartDate(rs.getDate("st_date").toLocalDate());
				cr.setEndDate(rs.getDate("end_date").toLocalDate());

				list.add(cr);
			}

		} catch (Exception e) {
			throw new StudentException("classroom :getClassRoom from db error.");
		}
		return list;
	}

	@Override
	public void updateClassRoom(ClassRoom room) {
		String sql = "update classroom_tbl set fees=?,duration=?,st_date=?,end_date=? where id =?";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, room.getFees());
			stmt.setInt(2, room.getDurations());
			stmt.setDate(3, Date.valueOf(room.getStartDate()));
			stmt.setDate(4, Date.valueOf(room.getEndDate()));
			stmt.setInt(5, room.getId());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void deleteClassRoom(int id) {
		String sql = "update classroom_tbl set  isActive=false  where id =?";
		try (var con = getConnector(); var stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
