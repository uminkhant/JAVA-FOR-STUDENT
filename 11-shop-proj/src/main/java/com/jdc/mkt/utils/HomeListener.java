package com.jdc.mkt.utils;


import com.jdc.mkt.service.CategoryService;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HomeListener implements ServletContextListener{
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		CategoryService cs=CategoryService.getCategoryService();
		sce.getServletContext().setAttribute("categories", cs.findBy(null,null,null));
		
	}
}
