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

		"/login", "/signUp", "/logout" })

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

	private void signUpMember(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		int id = req.getParameter("id") == null ? 0 : Integer.parseInt(req.getParameter("id"));
		var name = req.getParameter("user");
		var pass = req.getParameter("pass");
		var ph1 = req.getParameter("ph1");
		var ph2 = req.getParameter("ph2");
		
		String city = req.getParameter("city");
		String township = req.getParameter("township");
		String street = req.getParameter("street");

		

		// checkMember(req, resp);

		if (id > 0) {
			Address ad = new Address(0, city, township, street);
			MRole role=MRole.valueOf(req.getParameter("role"));
			Member m = new Member(0, name, pass, ph1, ph2, ad,role );
			memberService.updateMember(m);
		} else {
			Address ad = new Address(0, city, township, street);
			Member m = new Member(0, name, pass, ph1, ph2, ad, MRole.MEMBER);
			memberService.createMember(m);
		}

	}

	void checkMember(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		var userName = req.getParameter("user");
		var password = req.getParameter("pass");
		Member member = memberService.findMemberByName(userName);

		try {
			if (!member.password().equals(password)) {
				throw new NullPointerException("Password not match !");
			}

			if (member != null) {
				req.getSession(true).setAttribute("loginUser", member);

			}
		} catch (Exception e) {
			req.getRequestDispatcher("/security/error.jsp").forward(req, resp);
		}

	}

}
