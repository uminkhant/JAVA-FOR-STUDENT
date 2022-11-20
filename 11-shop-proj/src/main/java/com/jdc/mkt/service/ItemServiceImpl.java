package com.jdc.mkt.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.model.Item;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

class ItemServiceImpl implements ItemService {

	@Override
	public int createItem(Item item) {

		String sql = "insert into item_tbl(item_name,item_price,item_img,item_desc,cat_id) values(?,?,?,?,?)";
		try (Connection conn = getConnection(); var stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, item.name());
			stmt.setInt(2, item.price());
			stmt.setString(3, item.img());
			stmt.setString(4, item.desc());
			
			stmt.setInt(5, item.cat().id());

			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Item> findBy(int id,String iName, int iPrice,String catName,String catSize,String catSex) {

		StringBuffer sb = new StringBuffer(
				"Select i.id,i.item_name,i.item_price,i.item_img,i.item_desc,c.id,c.cat_name,c.cat_size,c.cat_sex from item_tbl i join category_tbl c on i.cat_id=c.id where 1=1");
		List<Item> items = new ArrayList<>();
		List<Object>tmp=new ArrayList<>();
		
		if(id>0) {
			sb.append(" and i.id=?");
			tmp.add(id);
		}

		if(iName != null && !iName.isEmpty()) {
			
			sb.append(" and i.item_name =?");
			tmp.add(iName);
		}
		
		if(iPrice>0) {
			
			sb.append(" and i.item_price =?");
			tmp.add(iPrice);
		}
		if(catName != null && !catName.isEmpty()) {
			sb.append(" and c.cat_name =?");
			tmp.add(catName);
		}
		
		if(catSize != null && !catSize.isEmpty()) {
			sb.append(" and c.cat_size =?");
			tmp.add(catSize);
		}
		
		if(catSex != null && !catSex.isEmpty()) {
			sb.append(" and c.cat_sex =?");
			tmp.add(catSex);
		}
		
		try (Connection conn = getConnection(); var stmt = conn.prepareStatement(sb.toString())) {

			for(int i=0;i<tmp.size();i++) {
				stmt.setObject(i+1, tmp.get(i));
			}
			
			var rs=stmt.executeQuery();
			
			while(rs.next()) {
				
				Category category=new Category(
						
						rs.getInt("c.id"),
						 rs.getString("c.cat_name"),
						 rs.getString("c.cat_size"),
						 rs.getString("c.cat_sex"));
				
				Item item=new Item(
						rs.getInt("i.id"),
						rs.getString("i.item_name"), 
						rs.getInt("i.item_price"),
						rs.getString("i.item_img"),
						rs.getString("i.item_desc"),
						category);
				
				items.add(item);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

}
