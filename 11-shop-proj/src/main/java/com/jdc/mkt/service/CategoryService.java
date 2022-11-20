package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Category;

public interface CategoryService {
	
	List<Category>findBy(String name,String size,String sex);
	int createCategory(Category cat);
	
	public static CategoryService getCategoryService() {
		return new CategoryServiceImpl();
	}
	
}
