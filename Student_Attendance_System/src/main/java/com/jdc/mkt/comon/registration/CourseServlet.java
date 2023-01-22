package com.jdc.mkt.comon.registration;

import java.io.IOException;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.ds.Course;
import com.jdc.mkt.service.CourseService;
import com.jdc.mkt.service.impl.CourseServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = { "/save-course", "/members/list-courses", "/admin/add-course", "/admin/edit-course",
		"/admin/delete-course" })
public class CourseServlet extends HttpServlet {

	private CourseService courseService;

	@Override
	public void init() throws ServletException {
		courseService = new CourseServiceImpl();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("courses", courseService.getCourses());

		switch (req.getServletPath()) {
		case "/members/list-courses":
		case "/admin/add-course":

			req.getRequestDispatcher("/header").include(req, resp);
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
			req.getRequestDispatcher("/footer").include(req, resp);
			break;
		case "/admin/edit-course":
			req.getRequestDispatcher(req.getContextPath().concat("/admin/add-course")).forward(req, resp);
			break;
		case "/admin/delete-course":
			var id =Integer.parseInt(req.getParameter("id"));
			Course c = new Course();
			c.setId(id);
			c.setActive(false);
			courseService.updateCourse(c);
			resp.sendRedirect(req.getContextPath().concat("/members/list-courses"));
			break;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String courseName = req.getParameter("name");
		int fees = Integer.parseInt(req.getParameter("fees"));
		String des = req.getParameter("des");
		String c = req.getParameter("room");

		int id = c == null ? 0 : Integer.parseInt(c);
		Course course = new Course();
		course.setName(courseName);
		course.setFees(fees);
		course.setActive(true);
		course.setDescription(des);
		course.setClassRoom(new ClassRoom(id));
		courseService.saveCourse(course);

		resp.sendRedirect(req.getContextPath().concat("/members/list-courses"));
	}

}
