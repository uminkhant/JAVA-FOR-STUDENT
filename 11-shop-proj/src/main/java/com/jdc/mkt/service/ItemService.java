package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.model.Item;

public interface ItemService {
	
	
	public void createItem(Item item);
	public List<Item>findBy(int id,String iName,int iPrice,String catName,String catSize,String catSex);

	public static ItemService getItemService() {
		return new ItemServiceImpl();
	}
}
