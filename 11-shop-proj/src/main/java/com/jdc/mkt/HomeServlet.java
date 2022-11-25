package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/add-category",
		"/editcategory",
		"/add-item",
		"/edititem",
		
		})
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var path = switch (req.getServletPath()) {
		case "/add-category" -> "/edits/add_category.jsp";
		case "/editcategory" -> "/edits/edit_category.jsp";
		case "/edititem" -> "/edits/edit_item.jsp";
		case "/add-item" -> "/edits/add_item.jsp";
		default -> null;
		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

}
