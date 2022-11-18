package com.jdc.mkt;

import java.io.IOException;

import com.jdc.mkt.service.ItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/searchItem")
public class ItemServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var category = req.getParameter("category");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		
		ItemService is=ItemService.getItemService();
		getServletContext().setAttribute("items", is.findBy(null, 0, category,size , sex));
		resp.sendRedirect(getServletContext().getContextPath().concat("/index.jsp"));
		
		
	}

}
