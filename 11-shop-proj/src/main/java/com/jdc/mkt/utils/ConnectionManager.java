package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private static final String URL="jdbc:mysql://localhost:3306/shop_db";
	private static final String USER="root";
	private static final String PASSWORD="admin123";
	
	
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
