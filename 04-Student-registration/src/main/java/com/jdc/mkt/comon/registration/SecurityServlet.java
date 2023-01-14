package com.jdc.mkt.comon.registration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/login",
		"/error",
		"/logout"
})
public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("commons/header.jsp").include(req, resp);
		req.getRequestDispatcher("security/"+req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("commons/footer.jsp").include(req, resp);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId = req.getParameter("loginId");
		String pass = req.getParameter("password");
		
		//req.login(loginId, pass);
		
		
		
	}

}
