package com.jdc.mkt.security;

import java.io.IOException;

import com.jdc.mkt.model.Member;
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

	private static Member member;

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

		switch (req.getServletPath()) {
		case "/login" -> checkMember(req, resp);

		case "/logout" -> req.getSession().invalidate();

		}

		resp.sendRedirect(req.getContextPath());
	}

	void checkMember(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		var userName = req.getParameter("user");
		var password = req.getParameter("pass");
		member = MemberService.getMeberService().findMember(userName, password);

		if (member != null) {
			req.getSession(true).setAttribute("loginUser", member);
			
		}else {
			resp.sendRedirect(req.getContextPath().concat("security/error.jsp"));
		}
		
	
	}

}
