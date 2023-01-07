package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnectionManager {
	
	@Resource(name="jdbc/student")
	private static DataSource ds;
	
	public static Connection getConnector()  {
		
		try {
//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/student");
//			Connection conn = ds.getConnection();		
//			
//			return conn;
			
			return ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
