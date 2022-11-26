package com.jdc.mkt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.model.Item;
import com.jdc.mkt.service.CategoryService;
import com.jdc.mkt.service.ItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = { "/searchItem", "/add_item", "/edit_item" })
@MultipartConfig
public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ItemService iService;
	private CategoryService catService;

	@Override
	public void init() throws ServletException {
		iService = ItemService.getItemService();
		catService = CategoryService.getCategoryService();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var path = switch (req.getServletPath()) {
		case "/edit_item" -> "/edits/edit_item.jsp";
		case "/add_item" -> "/edits/add_item.jsp";
		default -> "/edits/add_item.jsp";
		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var category = req.getParameter("category");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		var name = req.getParameter("itemName");
		var price = Integer.parseInt(req.getParameter("price") == null ? "0" : req.getParameter("price"));
		var desc = req.getParameter("desc");

		Part part = req.getPart("imageFile");

		if (null != part) {

			var file = Path.of(getServletContext().getRealPath("/images"), part.getSubmittedFileName());
			if (!file.toFile().exists()) {
				Files.copy(part.getInputStream(), file);
			}
		}

		switch (req.getServletPath()) {
		case "/searchItem":

			getServletContext().setAttribute("items", iService.findBy(0, name, 0, category, size, sex));
			resp.sendRedirect(getServletContext().getContextPath().concat("/index.jsp"));
			break;

		case "/add_item":
			List<Category> list = catService.findBy(category, size, sex);
			Item item = new Item(0, name, price, part.getSubmittedFileName(), desc, list.get(0));
			int i = iService.createItem(item);
			if (i > 0) {
				getServletContext().setAttribute("items", iService.findBy(0, null, 0, null, null, null));
			}
			req.getRequestDispatcher("/edits/add_item.jsp").forward(req, resp);

			break;

		}

	}

}
