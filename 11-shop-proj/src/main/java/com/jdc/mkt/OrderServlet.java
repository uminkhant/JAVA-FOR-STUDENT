package com.jdc.mkt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.OrderDetail;
import com.jdc.mkt.service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/order-detail-list", "/update-delivered-date", "/search-deails" })

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private OrderService orderService;
	private List<OrderDetail> list;

	@Override
	public void init() throws ServletException {
		orderService = OrderService.getOrderServivce();
		list = new ArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		switch (req.getServletPath()) {

		case "/order-detail-list":

			break;
		case "/update-delivered-date":
			int order_id = Integer.parseInt(req.getParameter("order_id"));
			orderService.updateDeliveredDate(LocalDate.now(), order_id);
			break;
		}
		list = orderService.getOrderDetail(null, null, null, null, null, null);
		req.setAttribute("orderDetails", list);

		req.getRequestDispatcher("/edits/orderdetails.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var member = req.getParameter("member");
		var category = req.getParameter("category");
		var size = req.getParameter("size");
		var sex = req.getParameter("sex");
		System.out.println(req.getParameter("from_dt"));
		var from_dt=LocalDate.parse(req.getParameter("from_dt"));
		var to_dt=LocalDate.parse(req.getParameter("to_dt"));
		
		list.clear();
		list = orderService.getOrderDetail(member, category, size, sex, from_dt, to_dt);

		System.out.println("search " + list.size());
		req.setAttribute("orderDetails", list);

		req.getRequestDispatcher("/edits/orderdetails.jsp").forward(req, resp);
	}
}
