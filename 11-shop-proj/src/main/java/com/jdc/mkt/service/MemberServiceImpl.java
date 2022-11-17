package com.jdc.mkt.service;

import com.jdc.mkt.model.Address;
import com.jdc.mkt.model.MRole;
import com.jdc.mkt.model.Member;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

import java.sql.Connection;

public class MemberServiceImpl implements MemberService {

	@Override
	public Member findMember(String name, String password) {

		String sql = "select m.id,m.login,m.password,m.phone1,m.phone2,m.role,a.id,a.street,a.township,a.city from member_tbl m join address_tbl a on m.address_id=a.id where m.login=? and m.password=?" ;
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, name);
			stmt.setString(2, password);
			
			var rs=stmt.executeQuery();
			
			while(rs.next()) {
				Address a=new Address(rs.getInt("a.id"),
						rs.getString("a.city"),
						rs.getString("a.township"),
						rs.getString("a.street"));
				Member m=new Member(rs.getInt("m.id"),
						rs.getString("m.login"),
						rs.getString("m.password"),
						rs.getString("m.phone1"),
						rs.getString("m.phone2"),
						a, MRole.valueOf(rs.getString("m.role").toUpperCase()));
				
				return m;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createMember() {
		String sql = "";
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
