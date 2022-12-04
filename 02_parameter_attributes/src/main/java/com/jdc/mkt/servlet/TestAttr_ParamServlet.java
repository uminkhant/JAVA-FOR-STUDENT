package com.jdc.mkt.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test" ,initParams = {
		@WebInitParam(name = "st_name",value = "Aung Aung"),
		@WebInitParam(name="st_age",value = "23")
})
public class TestAttr_ParamServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var initParams=getInitParameterNames();
		
		while(initParams.hasMoreElements()) {
			var param=initParams.nextElement();
			
			System.out.println(param+"\t" +getInitParameter(param));
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var params=req.getParameterNames();
		
		while(params.hasMoreElements()) {
			var param=params.nextElement();
			System.out.println("Param Name :%s".formatted(req.getParameter(param)));
		}
		
		var headers=req.getHeaderNames();
		
		while(headers.hasMoreElements()) {
			var header=headers.nextElement();
			
			System.out.println("Header :"+req.getHeader(header));
		}
		
		
	}
	
	
	
	@Override
	public String getServletInfo() {
	
		return "Hello servlet info";
	}

}
