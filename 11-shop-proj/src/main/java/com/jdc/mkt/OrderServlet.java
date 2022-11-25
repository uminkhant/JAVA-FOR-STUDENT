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

@WebServlet(urlPatterns = { "/order-detail-list", "/update-delivered-date" })
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private OrderService orderService;
	private List<OrderDetail>list;

	@Override
	public void init() throws ServletException {
		orderService = OrderService.getOrderServivce();
		list=new ArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		switch (req.getServletPath()) {
			
		case"/order-detail-list":
			
			break;
		case"/update-delivered-date":
			int order_id=Integer.parseInt(req.getParameter("order_id"));
			orderService.updateDeliveredDate(LocalDate.now(),order_id);
			break;
		}
		 list = orderService.getOrderDetail(null, null, null, null, null, null);
		req.setAttribute("orderDetails", list);

		req.getRequestDispatcher("/edits/orderdetails.jsp").forward(req, resp);
	}
}
