package com.jdc.mkt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Item;
import com.jdc.mkt.model.Member;
import com.jdc.mkt.model.Order;
import com.jdc.mkt.model.OrderDetail;
import com.jdc.mkt.service.ItemService;
import com.jdc.mkt.service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add-to-cart", "/clear-to-cart", "/cart-orders" ,"/take-order"})
public class AddToCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<OrderDetail> list;
	private ItemService service;
	private OrderService odService;

	@Override
	public void init() throws ServletException {
		list = new ArrayList<>();
		service = ItemService.getItemService();
		odService = OrderService.getOrderServivce();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var path = switch (req.getServletPath()) {

		case "/add-to-cart" -> {
			int id = Integer.parseInt(req.getParameter("id"));
			Item item = service.findBy(id, null, 0, null, null, null).stream().findFirst().get();

			addToOrderDetail(item);

			yield "/index.jsp";
		}

		case "/clear-to-cart" -> {
			list.clear();
			yield "/index.jsp";
		}
		case "/cart-orders" -> {
			req.setAttribute("total", getTotalPrice());
			req.setAttribute("qtys", gettotalQty());
			yield "/member/order.jsp";
		}

		default -> "";

		};

		req.setAttribute("orderDetailList", list);
		req.getRequestDispatcher(path).forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member=(Member) req.getSession().getAttribute("loginUser");
		Order o=new Order();
		o.setList(list);
		o.setDiscount(0);
		o.setMember(member);
		o.setOrder_dt(LocalDate.now());
		o.setTotal(getTotalPrice());
		
		int id=odService.addOrder(o);
		
		if(id>0) {
			list.clear();
			req.removeAttribute("list");
			req.setAttribute("message", "Thank you for ordering");
		}
		resp.sendRedirect(req.getContextPath());
		
	
	}

	private int getTotalPrice() {
		int total = list.stream().peek(p -> p.setTotal(p.getQty() * p.getItem().price())).mapToInt(t -> t.getTotal())
				.sum();
		return total;
	}

	private int gettotalQty() {
		int qtys = list.stream().mapToInt(m -> m.getQty()).sum();
		return qtys;
	}

	private void addToOrderDetail(Item item) {

		OrderDetail od = list.stream().filter(o -> o.getItem().id() == item.id()).peek(p -> p.setQty(p.getQty() + 1))
				.findFirst().orElse(null);

		if (od == null) {
			od = new OrderDetail();

			od.setItem(item);
			od.setQty(1);
			list.add(od);

		}

	}

}