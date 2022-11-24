package com.jdc.mkt.security;

import java.io.IOException;

import com.jdc.mkt.model.Address;
import com.jdc.mkt.model.MRole;
import com.jdc.mkt.model.Member;
import com.jdc.mkt.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {

		"/login", "/error", "/signUp", "/logout" })

public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static MemberService memberService;

	@Override
	public void init() throws ServletException {
		memberService = MemberService.getMeberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var path = switch (req.getServletPath()) {
		case "/login" -> "/security/login.jsp";
		case "/signUp" -> "/security/signUp.jsp";
		case "/error" -> "/security/error.jsp";
		case "/logout" -> {
			req.getSession().invalidate();
			yield "/index.jsp";
		}

		default -> null;

		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch (req.getServletPath()) {
		case "/login" -> checkMember(req, resp);

		case "/signUp" -> signUpMember(req, resp);

		}

		resp.sendRedirect(req.getContextPath());
	}

	private void signUpMember(HttpServletRequest req, HttpServletResponse resp) {

		var name = req.getParameter("user");
		var pass = req.getParameter("pass");
		var ph1 = req.getParameter("ph1");
		var ph2 = req.getParameter("ph2");
		String city = req.getParameter("city");
		String township = req.getParameter("township");
		String street = req.getParameter("street");
		
		
		
		Address ad = new Address(0, city, township, street);
		Member m = new Member(0, name, pass, ph1, ph2, ad, MRole.MEMBER);

		int id = memberService.createMember(m);
		
		if (id > 0) {
			req.setAttribute("message", "Successfully save member");
		}

	}

	void checkMember(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		var userName = req.getParameter("user");
		var password = req.getParameter("pass");
		Member member = memberService.findMember(userName, password);

		if (member != null) {
			req.getSession(true).setAttribute("loginUser", member);

		} else {
			resp.sendRedirect(req.getContextPath().concat("security/error.jsp"));
		}

	}

}
