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

public class AddItem extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ItemService iService;
	private CategoryService catService;

	@Override
	public void init() throws ServletException {
		iService = ItemService.getItemService();
		catService = CategoryService.getCategoryService();

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var category = req.getParameter("category");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		var name = req.getParameter("itemName");
		var price = Integer.parseInt(req.getParameter("price") == null ? "0" : req.getParameter("price"));
		var desc = req.getParameter("desc");

	//	System.out.println("file system :::" + getServletContext().getContextPath());

		Part part = req.getPart("imageFile");

		if (null != part) {

			var file=Path.of(getServletContext().getContextPath().concat("/images"), part.getSubmittedFileName());
			Files.copy(part.getInputStream(), file);
		}

		switch (req.getServletPath()) {
		case "/searchItem":

			getServletContext().setAttribute("items", iService.findBy(0, name, 0, category, size, sex));
			resp.sendRedirect(getServletContext().getContextPath().concat("/index.jsp"));
			break;

		case "/add_item":
			List<Category> list = catService.findBy(category, size, sex);
			System.out.println("category :" + list.get(0));
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
