package com.jdc.mkt;

import java.io.IOException;

import javax.sql.DataSource;

import com.jdc.mkt.sevice.UserService;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class SecurityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/test_db")
	DataSource ds;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var user = req.getParameter("user");
		var pass = req.getParameter("pass");
		
		System.out.println(user+"\t"+pass);
		
		
		//UserService service = new UserService(ds);

	//	req.getSession().setAttribute("loginUser", service.checkUser(user));
		
		//System.out.println("user : "+service.checkUser(user).getName());
		
		switch (req.getServletPath()) {

		case "/logout":
			req.getSession().invalidate();
			break;
		case "/login":
			req.login(user, pass);
			break;
		default:
			break;
		}
		
		
		
		resp.sendRedirect(req.getContextPath());
	}

}
