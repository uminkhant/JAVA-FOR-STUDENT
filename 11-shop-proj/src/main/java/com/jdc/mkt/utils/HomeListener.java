package com.jdc.mkt.utils;


import java.nio.file.Path;
import java.util.List;

import com.jdc.mkt.service.CategoryService;
import com.jdc.mkt.service.ItemService;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HomeListener implements ServletContextListener{
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		CategoryService cs=CategoryService.getCategoryService();
		ItemService is=ItemService.getItemService();
		
		
		
		List<String>listCatName=cs.findBy(null, null, null).stream().map(c->c.name()).distinct().toList();
		List<String>listCatSize=cs.findBy(null, null, null).stream().map(c->c.size()).distinct().toList();
		List<String>listCatSex=cs.findBy(null, null, null).stream().map(c->c.sex()).distinct().toList();
		
		sce.getServletContext().setAttribute("categories_name", listCatName);
		sce.getServletContext().setAttribute("categories_size", listCatSize);
		sce.getServletContext().setAttribute("categories_sex", listCatSex);
		sce.getServletContext().setAttribute("categories", cs.findBy(null, null, null));
		
		sce.getServletContext().setAttribute("items", is.findBy(0,null, 0, null, null, null));
		
		
	}
}
