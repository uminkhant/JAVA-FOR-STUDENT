package com.jdc.mkt.listener;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login","/logout"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/index.jsp"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var name = req.getParameter("name");
		var role = req.getParameter("role");

		var home=req.getParameter("home");
		
		if (role != null && !role.isEmpty()) {
			
			HttpSession session = req.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("role", role);
		}

		resp.sendRedirect(getServletContext().getContextPath().concat(String.format("/%s/home", home)));
	}

}
