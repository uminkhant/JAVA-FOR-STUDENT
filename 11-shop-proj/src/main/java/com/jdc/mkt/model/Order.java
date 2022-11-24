package com.jdc.mkt.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private int id;
	private Member member;
	private int total;
	private int discount;
	private List<OrderDetail>list;
	private LocalDate order_dt;
	private LocalDate delivered_dt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public List<OrderDetail> getList() {
		return list;
	}
	public void setList(List<OrderDetail> list) {
		this.list = list;
	}
	public LocalDate getOrder_dt() {
		return order_dt;
	}
	public void setOrder_dt(LocalDate order_dt) {
		this.order_dt = order_dt;
	}
	public LocalDate getDelivered_dt() {
		return delivered_dt;
	}
	public void setDelivered_dt(LocalDate delivered_dt) {
		this.delivered_dt = delivered_dt;
	}
	
	
	
}
