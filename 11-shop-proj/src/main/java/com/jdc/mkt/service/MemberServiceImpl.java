package com.jdc.mkt.service;

import com.jdc.mkt.model.Address;
import com.jdc.mkt.model.MRole;
import com.jdc.mkt.model.Member;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

import java.sql.Connection;
import java.sql.Statement;

public class MemberServiceImpl implements MemberService {

	@Override
	public Member findMember(String name, String password) {

		String sql = "select m.id,m.login,m.password,m.phone1,m.phone2,m.role,a.id,a.street,a.township,a.city from member_tbl m join address_tbl a on m.address_id=a.id where m.login=? and m.password=?";
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, name);
			stmt.setString(2, password);

			var rs = stmt.executeQuery();

			while (rs.next()) {
				Address a = new Address(rs.getInt("a.id"), rs.getString("a.city"), rs.getString("a.township"),
						rs.getString("a.street"));
				Member m = new Member(rs.getInt("m.id"), rs.getString("m.login"), rs.getString("m.password"),
						rs.getString("m.phone1"), rs.getString("m.phone2"), a,
						MRole.valueOf(rs.getString("m.role").toUpperCase()));

				return m;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createMember(Member member) {
		String sql = "insert into member_tbl (login,password,phone1,phone2,address_id)values(?,?,?,?,?)";
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, member.name());
			stmt.setString(2, member.password());
			stmt.setString(3, member.phoneOne());
			stmt.setString(4, member.phoneTwo());
			stmt.setInt(5, createAddress(member.addres().city(), member.addres().township(), member.addres().street()));
			int id = stmt.executeUpdate();
			
		
			return id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int createAddress(String city, String township, String street) {
		String sql = "insert into address_tbl (street,township,city)values(?,?,?)";
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, city);
			stmt.setString(2, township);
			stmt.setString(3, street);

			int id = stmt.executeUpdate();

			return id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
