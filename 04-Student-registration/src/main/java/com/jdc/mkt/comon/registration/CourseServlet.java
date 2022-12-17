package com.jdc.mkt.comon.registration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("commons/header.jsp").include(req, resp);
		req.getRequestDispatcher("add-course.jsp").include(req, resp);
		req.getRequestDispatcher("commons/footer.jsp").include(req, resp);
	}

}
