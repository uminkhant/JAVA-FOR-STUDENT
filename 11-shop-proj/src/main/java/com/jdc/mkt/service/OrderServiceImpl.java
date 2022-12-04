package com.jdc.mkt.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Address;
import com.jdc.mkt.model.Category;
import com.jdc.mkt.model.Item;
import com.jdc.mkt.model.Member;
import com.jdc.mkt.model.Order;
import com.jdc.mkt.model.OrderDetail;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class OrderServiceImpl implements OrderService {

	@Override
	public int addOrder(Order order) {
		String sql = "insert into order_tbl(member_id,total_price,discount,order_dt)values(?,?,?,?)";
		int id = 0;
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
	public List<OrderDetail> getOrderDetail(String member, String category, String sex, String size, LocalDate from_dt,
			LocalDate to_dt) {
		List<OrderDetail>od_list=new ArrayList<>();
		List<Object>tmp = new ArrayList<>();
		
		StringBuffer sb = new StringBuffer(
				"""
						select m.id, m.login,m.password,m.phone1,m.phone2,a.id,a.city,a.township,a.street,o.id,o.discount,o.delivered_dt,o.order_dt,i.item_name,i.id,i.item_price,i.item_img,i.item_desc,od.id,od.qty,od.total,c.id,c.cat_name,c.cat_size,c.cat_sex
						from order_details_tbl od join order_tbl o on od.order_id=o.id
						join item_tbl i on od.item_id=i.id
						join category_tbl c on cat_id=c.id
						join member_tbl m on o.member_id=m.id
						join address_tbl a on m.address_id=a.id where o.isActive=1 

						""");
		
		if(null != member && !member.isEmpty()) {
			sb.append(" and  m.login=?");
			tmp.add(member);
		}
		
		if(null != category && !category.isEmpty() ) {
			sb.append(" and c.cat_name=?");
			tmp.add(category);
		}	
		if(null != sex && !sex.isEmpty() ) {
			sb.append(" and c.cat_sex=?");
			tmp.add(sex);
		}	
		if(null != size && !size.isEmpty() ) {
			sb.append(" and c.cat_size=?");
			tmp.add(size);
		}
		
		if(from_dt!=null) {
			sb.append(" and o.delivered_dt >=?");
			tmp.add(from_dt);
		}
		
		if(to_dt!=null) {
			sb.append(" and o.delivered_dt <=?");
			tmp.add(to_dt);
		}
		sb.append(" order by o.id desc");

		try (var con = getConnection(); var stmt = con.prepareStatement(sb.toString())) {
			
			for(int i=0;i<tmp.size();i++) {
				stmt.setObject(i+1, tmp.get(i));
			}		
			var rs = stmt.executeQuery();		
			while (rs.next()) {			
				Address a=new Address(rs.getInt("a.id"),rs.getString("a.city") , rs.getString("a.township"), rs.getString("a.street"));
				Member m=new Member(rs.getInt("m.id"), rs.getString("m.login"), rs.getString("m.password"), rs.getString("m.phone1"), rs.getString("m.phone2"), a, null);
				Category c=new Category(rs.getInt("c.id"), rs.getString("c.cat_name"), rs.getString("c.cat_size"), rs.getString("c.cat_sex"));
				Item i=new Item(rs.getInt("i.id"),rs.getString("i.item_name") , rs.getInt("i.item_price"), rs.getString("i.item_img"), rs.getString("i.item_desc"), c);
				
				Order o=new Order();
				o.setId(rs.getInt("o.id"));
				o.setDelivered_dt(rs.getDate("o.delivered_dt")!=null? rs.getDate("o.delivered_dt").toLocalDate():null);
				o.setMember(m);
				o.setOrder_dt(rs.getDate("o.order_dt").toLocalDate());				
				rs.getString("m.login");	
				OrderDetail od=new OrderDetail();
				od.setId(rs.getInt("od.id"));
				od.setQty(rs.getInt("od.qty"));
				od.setTotal(rs.getInt("od.total"));
				od.setItem(i);
				od.setOrder(o);
				
				od_list.add(od);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return od_list;
	}

	@Override
	public void updateDeliveredDate(LocalDate delivered_dt,int order_id) {
		String sql="update order_tbl o join order_details_tbl od on od.order_id=o.id set o.delivered_dt=? where o.id=?";
		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			
			stmt.setDate(1, Date.valueOf( delivered_dt));
			stmt.setInt(2, order_id);		
			stmt.executeLargeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
