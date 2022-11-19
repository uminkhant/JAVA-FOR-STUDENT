package com.jdc.mkt.security;

import java.io.IOException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/list-to-order")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest) request;
		var login = req.getSession().getAttribute("loginUser");
		
		
		if (login != null) {
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("/security/login.jsp").forward(request, response);
		}
	}

}
