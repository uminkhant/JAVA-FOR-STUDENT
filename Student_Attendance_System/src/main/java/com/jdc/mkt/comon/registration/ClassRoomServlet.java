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

@WebServlet(urlPatterns = { "/members/list-classrooms", "/admin/add-classroom", "/admin/save-classroom",
		"/admin/edit-classroom", "/admin/delete-classroom" })
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
		int id = convertToInt(req.getParameter("id"));

		switch (req.getServletPath()) {
		case "/members/list-classrooms":
		case "/admin/add-classroom":
			req.getRequestDispatcher("/header").include(req, resp);
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
			req.getRequestDispatcher("/footer").include(req, resp);
			break;
		case "/admin/edit-classroom":
			ClassRoom cr = classRoomService.getClassRooms(id, null).stream().findFirst().orElse(null);
			req.setAttribute("classroom", cr);
			req.getRequestDispatcher("/admin/add-classroom").forward(req, resp);
			break;
		case "/admin/delete-classroom":
			classRoomService.deleteClassRoom(id);
			resp.sendRedirect(req.getContextPath().concat("/members/list-classrooms"));
			break;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String room = req.getParameter("room");
		int duration = convertToInt(req.getParameter("durations"));
		int fees = convertToInt(req.getParameter("fee"));
		int id = convertToInt(req.getParameter("id"));

		LocalDate st_date = LocalDate.parse(req.getParameter("start_date"));
		LocalDate end_date = LocalDate.parse(req.getParameter("end_date"));

		ClassRoom cl = new ClassRoom();
		cl.setName(room);
		cl.setFees(fees);
		cl.setDurations(duration);
		cl.setStartDate(st_date);
		cl.setEndDate(end_date);
		cl.setActive(true);
		
		if (id > 0) {
			cl.setId(id);
			classRoomService.updateClassRoom(cl);
		} else {
			classRoomService.saveClassRoom(cl);
		}

		resp.sendRedirect(req.getContextPath());
	}

	private int convertToInt(String str) {
		return null == str ? 0 : Integer.parseInt(str);
	}

}
