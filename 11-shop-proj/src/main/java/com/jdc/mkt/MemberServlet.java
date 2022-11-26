package com.jdc.mkt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Member;
import com.jdc.mkt.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/update-members", "/member"})
public class MemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	private List<Member> list;

	@Override
	public void init() throws ServletException {
		memberService = MemberService.getMeberService();
		list = new ArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var id = req.getParameter("Memberid") == null ? 0 : Integer.parseInt(req.getParameter("Memberid"));

		var path = switch (req.getServletPath()) {
		case "/member" -> {
			list.clear();
			list = memberService.findMember(0, null);
			yield "/edits/members.jsp";
		}

		case "/update-members" -> {
			list.clear();
			list = memberService.findMember(id, null);
			yield "/security/signUp.jsp";
		}
		default -> null;
		};
		req.setAttribute("members", list);
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
