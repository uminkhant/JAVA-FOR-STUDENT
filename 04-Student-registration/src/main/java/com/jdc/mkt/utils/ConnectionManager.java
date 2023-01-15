package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;

public class ConnectionManager {
	
//	@Resource(name ="jdbc/student")
//	private static DataSource ds;
	
	public static Connection getConnector() throws SQLException, NamingException  {
		
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");
		
		return ds.getConnection();
	}

}
