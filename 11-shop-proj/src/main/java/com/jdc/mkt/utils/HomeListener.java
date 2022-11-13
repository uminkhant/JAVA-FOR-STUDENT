package com.jdc.mkt.utils;


import com.jdc.mkt.service.CategoryService;
import com.jdc.mkt.serviceImpl.CategoryServiceImpl;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HomeListener implements ServletContextListener{
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		CategoryService cs=new CategoryServiceImpl();
		cs.getAllCatgory().forEach(c->System.out.println(c.name()));
		sce.getServletContext().setAttribute("categories", cs.getAllCatgory());
		
	}
}
