package com.jdc.mkt.comon.registration;

import java.io.IOException;

import com.jdc.mkt.ds.Member;
import com.jdc.mkt.ds.Role;
import com.jdc.mkt.service.MemberService;
import com.jdc.mkt.service.impl.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/add-member", "/list-members","/save-member" })
public class MemberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private MemberService mService;
	
	@Override
	public void init() throws ServletException {
		mService = new MemberServiceImpl();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/header").include(req, resp);
		
		if(req.getServletPath().startsWith("/add")) {
			req.getRequestDispatcher("/admin"+req.getServletPath().concat(".jsp")).include(req, resp);
		}else {
			req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		}
		req.getRequestDispatcher("/footer").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("mName");
		String pass = req.getParameter("pass");
		Role role = Role.valueOf(req.getParameter("role").toUpperCase());
		
		Member m = new Member();
		m.setName(name);
		m.setPassword(pass);
		m.setRole(role);
		
		mService.saveMember(m);
		resp.sendRedirect(getServletContext().getContextPath().concat("/add-member"));
	}

}
