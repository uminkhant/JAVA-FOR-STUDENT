package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;


public class ConnectionManager {
	
//	@Resource(name ="jdbc/student")
//	private static DataSource ds;
	
	private static final String URL="jdbc:mysql://localhost:3306/student_db";
	private static final String USER="root";
	private static final String PASS="admin123";
	
	public static Connection getConnector() throws SQLException, ClassNotFoundException, NamingException  {
		
//		InitialContext ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");
		
		//return ds.getConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASS);
	}


}
