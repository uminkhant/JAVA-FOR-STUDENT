package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.ds.Attendance;
import com.jdc.mkt.ds.ClassRoom;
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

@WebServlet(urlPatterns = { "/members/list-attendance", "/admin/add-attendance", "/addToAttendance",
		"/select-classroom" })
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
		case "/select-classroom":
			req.removeAttribute("students");
			stuList = stuService.getStudents(0, null, req.getParameter("room"));
			System.out.println(stuList.size());
			req.setAttribute("students", stuList);
			req.getRequestDispatcher("/admin/add-attendance").forward(req, resp);
			break;
		case "/addToAttendance":
			String dd = req.getParameter("date");
			LocalDate ld =dd!=null? LocalDate.parse(dd):LocalDate.now();
			for (Student a : stuList) {
				int id = a.getId();
				int stu_id = Integer.parseInt(req.getParameter(id + "stu"));
				boolean present = Boolean.parseBoolean(req.getParameter(id + "abs"));
				Attendance tt = new Attendance();
				tt.setAttDate(ld);
				tt.setStudent(new Student(stu_id));
				tt.setAbsent(present);
				attendances.add(tt);

			}
			resp.sendRedirect(req.getContextPath().concat("/members/list-attendance"));
			break;

		}

	}

}
