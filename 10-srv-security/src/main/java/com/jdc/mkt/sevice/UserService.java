package com.jdc.mkt.sevice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.jdc.mkt.model.Role;
import com.jdc.mkt.model.User;

public class UserService {

	private DataSource ds;
	
	public UserService(DataSource  ds) {
		this.ds=ds;
	}
	
	public User checkUser(String name) {
		
		String sql="select * from member_tbl where login=?";
		
		try(
				Connection con=ds.getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)
				
				) {
			
			System.out.println("db test");
			
			stmt.setString(1, name);
			var rs=stmt.executeQuery();
			
			while(rs.next()) {
				User u=new User();
				u.setName(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				u.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
			
				return u;
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
