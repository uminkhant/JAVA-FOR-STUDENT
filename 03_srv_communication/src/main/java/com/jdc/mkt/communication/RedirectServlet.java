package com.jdc.mkt.communication;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// relative path
		req.getRequestDispatcher("/header").include(req, resp);

		req.getRequestDispatcher("/form").include(req, resp);

		// relative path
		req.getRequestDispatcher("/footer").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var name = req.getParameter("name");
		var age = req.getParameter("age");

		System.out.println("Customer name is %s and age is %s".formatted(name, age));
		
	 resp.sendRedirect(getServletContext().getContextPath().concat("/redirect"));

	}

}
