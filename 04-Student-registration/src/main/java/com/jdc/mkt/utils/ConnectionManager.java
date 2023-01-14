package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.annotation.Resource;

public class ConnectionManager {
	
	
	
	@Resource(name ="jdbc/student")
	private static DataSource ds;
	
	public static Connection getConnector() throws SQLException  {
		return ds.getConnection();
	}

}
