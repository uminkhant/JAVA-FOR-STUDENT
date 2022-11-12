package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Category;

public interface CategoryService {
	
	

	List<Category>getAllCatgory();
	void createCategory(Category cat);
}
