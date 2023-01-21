package com.jdc.mkt.utils;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/error", "/logout" })
public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		if (req.getServletPath().equals("/login")) {
			req.getRequestDispatcher("commons/header.jsp").include(req, resp);
			req.getRequestDispatcher("/security" + req.getServletPath().concat(".jsp")).include(req, resp);
			req.getRequestDispatcher("commons/footer.jsp").include(req, resp);
		} else {
			req.logout();
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		try {

			String loginId = req.getParameter("loginId");
			String pass = req.getParameter("password");
			req.login(loginId, pass);

			var session = req.getSession();
			session.setAttribute("loginUser", req.getUserPrincipal());
			session.setAttribute("userName", req.getUserPrincipal().getName());
			session.setAttribute("isAdmin", req.isUserInRole("ADMIN"));

			resp.sendRedirect(req.getContextPath());

		} catch (Exception e) {

			resp.sendRedirect(req.getContextPath().concat("/error"));

		}

	}

}
