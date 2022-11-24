package com.jdc.mkt.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.model.Order;
import com.jdc.mkt.model.OrderDetail;

public interface OrderService {

	int addOrder(Order order);
	List<OrderDetail> getOrderDetail(String member,String catgory,String sex,String size,LocalDate st_dt,LocalDate to_dt);

	
	public static OrderService getOrderServivce() {
		return new OrderServiceImpl();
	}
}
