package com.jdc.mkt.comon.registration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/list-students","/save-student","/admin/add-student"})
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/header").include(req, resp);
			
		if(req.getServletPath().startsWith("/add")) {
			req.getRequestDispatcher("/admin"+req.getServletPath().concat(".jsp")).include(req, resp);
		}else {
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		}
		
		req.getRequestDispatcher("/footer").include(req, resp);
	}
	
	
}
