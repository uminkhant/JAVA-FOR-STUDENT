package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.ds.ClassRoom;

public interface ClassRoomService {

	void saveClassRoom(ClassRoom classroom);
	List<ClassRoom>getClassRooms(int id,String name);
	void updateClassRoom(ClassRoom room);
	void deleteClassRoom(int id);
	
}
