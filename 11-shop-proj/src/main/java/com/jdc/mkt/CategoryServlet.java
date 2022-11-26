package com.jdc.mkt;

import java.io.IOException;
import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add_category", "/edit_category" })
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoryService service;

	@Override
	public void init() throws ServletException {
		service = CategoryService.getCategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var path = switch (req.getServletPath()) {
		case "/add_category" -> "/edits/add_category.jsp";
		case "/edit_category" -> "/edits/edit_category.jsp";
		default -> null;

		};
		
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var catname = req.getParameter("catName");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");

		Category c = new Category(0, catname, size, sex);
		int i = service.createCategory(c);

		if (i > 0) {
			req.setAttribute("message", "Successfully save !");
		}
		getServletContext().setAttribute("categories", service.findBy(null, null, null));
		req.getRequestDispatcher("/edits/add_category.jsp").forward(req, resp);

	}

}
