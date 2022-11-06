package com.jdc.mkt;

import java.io.IOException;

import com.jdc.mkt.model.User;
import com.jdc.mkt.sevice.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var user=req.getParameter("user");
		var pass=req.getParameter("pass");
		UserService service=new UserService();
		
		User u=service.checkUser(user);
		
		
		
		switch (req.getServletPath()) {
		
		case "/logout":
			req.getSession().invalidate();
			break;
		case "/login":
			
			if(null!=u) {
				
				req.login(user, pass);	
				System.out.println(u.getName()+"\t"+u.getPassword());
			
			}else {
				System.out.println("There is no user");
			}
			
			
			var session=req.getSession();
			session.setAttribute("loginUser", req.getUserPrincipal());
			session.setAttribute("userName", req.getUserPrincipal().getName());
			session.setAttribute("isAdmin", req.isUserInRole("Admin"));
			
			break;
		default:
			break;
		}
		
		resp.sendRedirect(req.getContextPath());
	}

}
