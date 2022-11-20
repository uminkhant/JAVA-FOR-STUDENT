package com.jdc.mkt;

import java.io.IOException;
import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.model.Item;
import com.jdc.mkt.service.CategoryService;
import com.jdc.mkt.service.ItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/searchItem", "/save-item" })
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var category = req.getParameter("category");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		var name = req.getParameter("itemName");
		var price = Integer.parseInt(req.getParameter("price"));
		var img = req.getParameter("img");
		var desc = req.getParameter("desc");
		
		System.out.println(" category :"+category+"\t"+size+"\t"+sex);

		switch (req.getServletPath()) {
		case "/searchItem":
			getServletContext().setAttribute("items", iService.findBy(0, null, 0, category, size, sex));

			resp.sendRedirect(getServletContext().getContextPath().concat("/index.jsp"));
			break;
			
		case "/save-item":
			List<Category> list = catService.findBy(category, size, sex);
			System.out.println("category :"+list.get(0));
			Item item = new Item(0, name, price, img, desc, list.get(0));
			int i = iService.createItem(item);
			if (i > 0) {
				req.setAttribute("message", "successfully save item !");
			}
			req.getRequestDispatcher("/edits/item.jsp").forward(req, resp);

			break;

		}

	}

}
