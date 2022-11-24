package com.jdc.mkt.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.model.Order;
import com.jdc.mkt.model.OrderDetail;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class OrderServiceImpl implements OrderService {

	@Override
	public int addOrder(Order order) {
		String sql = "insert into order_tbl(member_id,total_price,discount,order_dt)values(?,?,?,?)";
		int id=0;
		try (var con = getConnection(); var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setInt(1, order.getMember().id());
			stmt.setInt(2, order.getTotal());
			stmt.setInt(3, 0);
			stmt.setDate(4, Date.valueOf(order.getOrder_dt()));

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				 id = rs.getInt(1);
			}

			addOrderDetail(order.getList(), id);
			return id;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	private void addOrderDetail(List<OrderDetail> list, int id) {
		String sql = "insert into order_details_tbl(order_id,qty,total,item_id)values(?,?,?,?)";
		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

			for (OrderDetail od : list) {
				stmt.setInt(1, id);
				stmt.setInt(2, od.getQty());
				stmt.setInt(3, od.getTotal());
				stmt.setInt(4, od.getItem().id());
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderDetail> getOrderDetail(String member, String catgory, String sex, String size, LocalDate st_dt,
			LocalDate to_dt) {
		String sql = "";
		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
