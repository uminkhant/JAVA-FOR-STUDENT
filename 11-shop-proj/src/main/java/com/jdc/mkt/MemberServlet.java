package com.jdc.mkt;

import java.io.IOException;

import com.jdc.mkt.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/edit-members", "/member" })
public class MemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		memberService=MemberService.getMeberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var path = switch (req.getServletPath()) {
		case "/member" -> "/edits/members.jsp";
		case "/edit-members" -> "/edits/members.jsp";
		default -> null;
		};
		req.setAttribute("members", memberService.findMember());
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
