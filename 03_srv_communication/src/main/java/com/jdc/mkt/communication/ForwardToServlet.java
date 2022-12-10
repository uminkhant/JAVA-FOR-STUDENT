package com.jdc.mkt.communication;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/forwardTo")
public class ForwardToServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var message=req.getAttribute("message");
		
		//relative path 
		req.getRequestDispatcher("/header").include(req, resp);
		
		resp.getWriter().append("<p>")
		.append((CharSequence) message)
		.append("</p>");
		
		//relative path
		req.getRequestDispatcher("/footer").include(req, resp);
	}

}
