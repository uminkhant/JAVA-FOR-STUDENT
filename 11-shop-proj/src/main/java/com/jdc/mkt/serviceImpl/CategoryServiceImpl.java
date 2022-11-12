package com.jdc.mkt.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.service.CategoryService;

import jakarta.annotation.Resource;

public class CategoryServiceImpl implements CategoryService{
	
	@Resource(name="jdbc/shop_db")
	DataSource ds;

	@Override
	public List<Category> getAllCatgory() {
		
		String sql = "select * from category_tbl ";
		
		try(Connection conn=ds.getConnection();var stmt=conn.prepareStatement(sql)){
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createCategory(Category cat) {
		// TODO Auto-generated method stub
		
	}

	
	
}
