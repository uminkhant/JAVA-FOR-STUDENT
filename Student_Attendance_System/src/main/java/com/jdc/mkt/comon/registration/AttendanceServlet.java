package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.ds.Student;
import com.jdc.mkt.service.AttendanceService;
import com.jdc.mkt.service.StudentService;
import com.jdc.mkt.service.impl.AttendanceServiceImpl;
import com.jdc.mkt.service.impl.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/members/list-attendance",
		"/admin/add-attendance",
		"/addToAttendance",
		"/list-select-classroom" ,
		"/add-select-classroom"})

public class AttendanceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<Attendance> attendances;
	private AttendanceService attService;
	private StudentService stuService;
	private List<Student> stuList;

	@Override
	public void init() throws ServletException {
		attendances = new ArrayList<>();
		stuList = new ArrayList<>();
		stuService = new StudentServiceImpl();
		attService = new AttendanceServiceImpl();
		stuList = stuService.getStudents(0, null, null);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		switch (req.getServletPath()) {
		
		case "/members/list-attendance":
		case "/admin/add-attendance":
			req.getRequestDispatcher("/commons/header.jsp").include(req, resp);
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
			req.getRequestDispatcher("/commons/footer.jsp").include(req, resp);
			break;
			
		case "/list-select-classroom":
			System.out.println("date ::::::::::::::::"+req.getParameter("date"));
			attendances = attService.getAttendance(0, null, req.getParameter("room"),getLocalDate(req));
			req.removeAttribute("attendances");
			req.setAttribute("attendances", attendances);
			req.getRequestDispatcher("/members/list-attendance").forward(req, resp);
			break;
			
		case "/add-select-classroom":	
			System.out.println("date ::::::::::::::::"+req.getParameter("date"));
			stuList = stuService.getStudents(0, null, req.getParameter("room"));		
			req.removeAttribute("students");
			req.setAttribute("students", stuList);
			req.getRequestDispatcher("/admin/add-attendance").forward(req, resp);
			break;
			
		case "/addToAttendance":
			addToAttendanceList(req, resp);
			resp.sendRedirect(req.getContextPath().concat("/members/list-attendance"));
			break;

		}

	}


	private void addToAttendanceList(HttpServletRequest req, HttpServletResponse resp) {
		
	
		for (Student a : stuList) {
			int id = a.getId();
			int stu_id = Integer.parseInt(req.getParameter(id + "stu"));
			boolean present = Boolean.parseBoolean(req.getParameter(id + "abs"));
			Attendance tt = new Attendance();
			tt.setAttDate(getLocalDate(req));
			tt.setStudent(new Student(stu_id));
			tt.setPresent(present);
			attendances.add(tt);

			
		}
		attService.addAttendance(attendances);
	}
	
	private LocalDate getLocalDate(HttpServletRequest req) {
		String dd = req.getParameter("date");
		return dd != null? LocalDate.parse(dd) : LocalDate.now();
	}

}
