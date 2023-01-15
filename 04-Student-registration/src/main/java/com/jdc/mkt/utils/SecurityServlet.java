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
		req.getRequestDispatcher("commons/header.jsp").include(req, resp);
		req.getRequestDispatcher("security/" + req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("commons/footer.jsp").include(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("login : ");
		switch (req.getServletPath()) {
		case "/login":

			String loginId = req.getParameter("loginId");
			String pass = req.getParameter("password");
			System.out.println("login : "+loginId);
			req.login(loginId, pass);
			
			var session = req.getSession();
			session.setAttribute("loginUser", req.getUserPrincipal());
			session.setAttribute("userName", req.getUserPrincipal().getName());
			session.setAttribute("isAdmin", req.isUserInRole("ADMIN"));
			
			break;
		case "/logout":
			req.logout();
			req.getSession().invalidate();
			break;
		default:
			break;
		}

		resp.sendRedirect(req.getContextPath());

	}

}
