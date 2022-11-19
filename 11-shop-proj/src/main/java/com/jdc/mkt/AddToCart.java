package com.jdc.mkt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Item;
import com.jdc.mkt.service.ItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add-to-cart", "/clear-to-cart", "/list-to-order" })
public class AddToCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<Item> list;
	private ItemService service;

	@Override
	public void init() throws ServletException {
		list = new ArrayList<>();
		service = ItemService.getItemService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var path = switch (req.getServletPath()) {

		case "/add-to-cart" -> {

			int id = Integer.parseInt(req.getParameter("id"));
			List<Item> tmp = service.findBy(id, null, 0, null, null, null);

			list.add(tmp.get(0));

			yield "/index.jsp";
		}

		case "/clear-to-cart" -> {
			list.clear();
			yield "/index.jsp";
		}
		case "/list-to-order" -> "/member/order.jsp";

		default -> "";

		};

		req.setAttribute("orderList", list);
		req.getRequestDispatcher(path).forward(req, resp);

	}

}
