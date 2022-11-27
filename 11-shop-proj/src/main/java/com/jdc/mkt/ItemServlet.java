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

@WebServlet(urlPatterns = { "/searchItem", "/add_item", "/edit_item", "/update_item", "/delete_item" })
@MultipartConfig
public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ItemService iService;
	private CategoryService catService;
	private Item item;

	@Override
	public void init() throws ServletException {
		iService = ItemService.getItemService();
		catService = CategoryService.getCategoryService();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var id = req.getParameter("item_id") == null ? 0 : Integer.parseInt(req.getParameter("item_id"));

		var path = switch (req.getServletPath()) {
		case "/edit_item" -> "/edits/edit_item.jsp";
		case "/add_item", "/update_item" -> {
			
			if (id > 0) {
				item = iService.findBy(id, null, 0, null, null, null).get(0);
				req.setAttribute("item", item);
			}
			yield "/edits/add_item.jsp";
		}

		case "/delete_item" -> {
			iService.deleteItemById(id);
			req.setAttribute("items", iService.findBy(0, null, 0, null, null, null));
			yield "/edits/edit_item.jsp";
		}
		default -> "/edits/add_item.jsp";
		};

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var id = req.getParameter("item_id") == null ? 0 : Integer.parseInt(req.getParameter("item_id"));
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
			List<Category> list = catService.findBy(0, category, size, sex);
			var path = "";
			if (id > 0) {
				Item updItem = new Item(item.id(), item.name(), price, part.getSubmittedFileName(), desc, item.cat());
				iService.updateItem(updItem);
				path = "/edits/edit_item.jsp";
			} else {
				Item crdItem = new Item(0, name, price, part.getSubmittedFileName(), desc, list.get(0));
				iService.createItem(crdItem);
				path = "/edits/add_item.jsp";
			}
			getServletContext().setAttribute("items", iService.findBy(0, null, 0, null, null, null));
			req.getRequestDispatcher(path).forward(req, resp);

			break;

		}

	}

}
