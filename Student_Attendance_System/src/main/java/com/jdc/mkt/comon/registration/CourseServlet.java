package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.util.List;

import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.ds.Course;
import com.jdc.mkt.service.CourseService;
import com.jdc.mkt.service.impl.CourseServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = { "/admin/save-course", "/admin/update-course", "/members/list-courses", "/admin/add-course",
		"/admin/edit-course", "/admin/delete-course" })
public class CourseServlet extends HttpServlet {

	private CourseService courseService;

	@Override
	public void init() throws ServletException {
		courseService = new CourseServiceImpl();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Course> list = courseService.getCourses(0, null);
		req.setAttribute("courses", list);
		String str = req.getParameter("id");
		int course_id = convertToInt(str);

		switch (req.getServletPath()) {
		case "/members/list-courses":
		case "/admin/add-course":

			req.getRequestDispatcher("/header").include(req, resp);
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
			req.getRequestDispatcher("/footer").include(req, resp);
			break;
		case "/admin/edit-course":
			Course course = courseService.getCourses(course_id, null).stream().findFirst().orElse(null);
			req.setAttribute("course", course);

			req.getRequestDispatcher("/admin/add-course").forward(req, resp);
			break;
		case "/admin/delete-course":
			courseService.deleteCourse(course_id);
			resp.sendRedirect(req.getContextPath().concat("/members/list-courses"));
			break;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String courseName = req.getParameter("name");
		String des = req.getParameter("des");
		String str = req.getParameter("id");
		int id = convertToInt(str);

		Course course = new Course();
		course.setName(courseName);
		course.setActive(true);
		course.setDescription(des);

		if (id > 0) {
			course.setId(id);
			System.out.println("update : course"+id);
			courseService.updateCourse(course);
		}else {
			System.out.println("save");
			courseService.saveCourse(course);
		}

		resp.sendRedirect(req.getContextPath().concat("/members/list-courses"));
	}

	private int convertToInt(String str) {
		return str == null ? 0 : Integer.parseInt(str);
	}

}
