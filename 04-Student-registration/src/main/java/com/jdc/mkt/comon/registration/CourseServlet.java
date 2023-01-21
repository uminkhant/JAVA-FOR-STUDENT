package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.jdc.mkt.utils.ConnectionManager.getConnector;

@WebServlet(value = { "/save-course", "/members/list-courses", "/admin/add-course" })
public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/header").include(req, resp);
		req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("/footer").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String courseName = req.getParameter("");
		int fees = Integer.parseInt(req.getParameter(""));
		String des = req.getParameter("");

	}

}
