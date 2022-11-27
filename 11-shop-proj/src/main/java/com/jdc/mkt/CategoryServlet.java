package com.jdc.mkt;

import java.io.IOException;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add_category", "/edit_category", "/delete_category", "/update_category" })
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoryService service;

	@Override
	public void init() throws ServletException {
		service = CategoryService.getCategoryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = req.getParameter("cat_id") == null ? 0 : Integer.parseInt(req.getParameter("cat_id"));

		var path = switch (req.getServletPath()) {
		
		case "/add_category", "/update_category" -> {
			if (id > 0) {
				Category category = service.findBy(id, null, null, null).get(0);
				req.setAttribute("category", category);
			}
			yield "/edits/add_category.jsp";
		}
		case "/delete_category" -> {
			service.deleteCategory(id);
			req.removeAttribute("categories");
			req.setAttribute("categories", service.findBy(0, null, null, null));
			yield "/edits/edit_category.jsp";
		}
		case "/edit_category" -> "/edits/edit_category.jsp";
		
		default -> null;

		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = req.getParameter("cat_id") == null ? 0 : Integer.parseInt(req.getParameter("cat_id"));

		var catname = req.getParameter("catName");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		var path="";
		if (id > 0) {
			Category c = new Category(id, catname, size, sex);
			service.updateCategory(c);
			path="/edits/edit_category.jsp";
		} else {
			Category c = new Category(0, catname, size, sex);
			service.createCategory(c);
			path="/edits/add_category.jsp";
		}
		req.removeAttribute("categories");
		req.setAttribute("categories", service.findBy(0, null, null, null));
		req.getRequestDispatcher(path).forward(req, resp);

	}

}
