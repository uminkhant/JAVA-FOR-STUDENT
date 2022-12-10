package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1,urlPatterns = "/student",name="srv1")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Hello do get");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var name=req.getParameter("st_name");
		var age=Integer.parseInt(req.getParameter("st_age")) ;
		
		Student st=new Student();
		st.setName(name);
		st.setAge(age);
		
		req.getSession(true).setAttribute("student", st);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
