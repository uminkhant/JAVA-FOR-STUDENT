package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.time.LocalDate;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.service.ClassRoomService;
import com.jdc.mkt.service.impl.ClassRoomServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/members/list-classrooms", "/admin/add-classroom", "/save-classroom" })
public class ClassRoomServlet extends HttpServlet {

	private ClassRoomService classRoomService;

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		classRoomService = new ClassRoomServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("classrooms", classRoomService.getClassRooms(0, null));
		
		req.getRequestDispatcher("/header").include(req, resp);
		req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("/footer").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String room = req.getParameter("room");
		int duration = Integer.parseInt(req.getParameter("durations"));
		LocalDate st_date = LocalDate.parse(req.getParameter("start_date"));
		LocalDate end_date = LocalDate.parse(req.getParameter("end_date"));

		ClassRoom classRoom = new ClassRoom(room, duration, st_date, end_date);
		classRoomService.saveClassRoom(classRoom);

		resp.sendRedirect(req.getContextPath());
	}

}
