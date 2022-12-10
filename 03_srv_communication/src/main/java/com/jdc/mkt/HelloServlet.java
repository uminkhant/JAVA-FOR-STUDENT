package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/","/include"})
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//relative path 
		req.getRequestDispatcher("/header").include(req, resp);
		
		getServletContext().getNamedDispatcher("message").include(req, resp);
		
		//relative path
		req.getRequestDispatcher("/footer").include(req, resp);
		
		
	
		
	}

	
}
