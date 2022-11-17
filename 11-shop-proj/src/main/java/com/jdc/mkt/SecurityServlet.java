package com.jdc.mkt;

import java.io.IOException;

import com.jdc.mkt.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {

		"/login", "/error", "/signUp" })

public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var path = switch (req.getServletPath()) {
		case "/login" -> "/security/login.jsp";
		case "/signUp" -> "/security/signUp.jsp";
		case "/error" -> "/security/error.jsp";
		default -> null;

		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var userName = req.getParameter("user");
		var password = req.getParameter("pass");
		switch (req.getServletPath()) {
		case "/login" -> {
			req.login(userName, password);
			}

		}

		req.getSession(true).setAttribute("loginUser", MemberService.getMeberService().findMember(userName, password));
		
		resp.sendRedirect(req.getContextPath());
	}

}
