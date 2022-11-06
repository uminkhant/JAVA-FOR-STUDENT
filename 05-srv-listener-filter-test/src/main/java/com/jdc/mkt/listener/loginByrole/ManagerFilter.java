package com.jdc.mkt.listener.loginByrole;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/manager/*")
public class ManagerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		var user = session.getAttribute("name");
		var role = session.getAttribute("role");

		if (user != null && role != null && "manager".equals("manager")) {

			chain.doFilter(request, response);

		} else {
			
			req.setAttribute("message", "You have to login with name and role");
			req.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
