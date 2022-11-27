package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Category;

public interface CategoryService {
	
	List<Category>findBy(int id,String name,String size,String sex);
	int createCategory(Category cat);
	void updateCategory(Category cat);
	void deleteCategory(int id);
	
	public static CategoryService getCategoryService() {
		return new CategoryServiceImpl();
	}
	
}
