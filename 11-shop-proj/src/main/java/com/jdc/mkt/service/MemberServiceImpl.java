package com.jdc.mkt.service;

import com.jdc.mkt.model.Address;
import com.jdc.mkt.model.MRole;
import com.jdc.mkt.model.Member;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {

	@Override
	public Member findMemberByName(String name) {

		String sql = "select m.id,m.login,m.password,m.phone1,m.phone2,m.role,a.id,a.street,a.township,a.city from member_tbl m join address_tbl a on m.address_id=a.id where m.login=? ";
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, name);
			
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
			stmt.setInt(5,
					createAddress(member.address().city(), member.address().township(), member.address().street()));
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

	@Override
	public List<Member> findMember(int id, String name) {
		List<Member> list = new ArrayList<>();
		List<Object> tmp = new ArrayList<>();

		String sql = "select m.id,m.login,m.password,m.phone1,m.phone2,m.role,a.id,a.street,a.township,a.city from member_tbl m join address_tbl a on m.address_id=a.id  where m.isActive=1";

		StringBuffer sb = new StringBuffer(sql);

		if(id>0) {
			sb.append(" and m.id=?");
			tmp.add(id);
		}
		if(name != null && !name.isEmpty()) {
			sb.append(" and m.login=?");
			tmp.add(name);
		}
		
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sb.toString())) {

			
			for(int i = 0;i<tmp.size() ;i++) {
				stmt.setObject(i+1, tmp.get(i));
			}
			
			var rs = stmt.executeQuery();

			while (rs.next()) {
				Address a = new Address(rs.getInt("a.id"), rs.getString("a.city"), rs.getString("a.township"),
						rs.getString("a.street"));
				Member m = new Member(rs.getInt("m.id"), rs.getString("m.login"), rs.getString("m.password"),
						rs.getString("m.phone1"), rs.getString("m.phone2"), a,
						MRole.valueOf(rs.getString("m.role").toUpperCase()));

				list.add(m);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void deleteMemberById(int id) {
		String sql = "update member_tbl set isActive=false where id=?";
		
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMember(Member member) {
		String sql = "update member_tbl set login=?,password=?,phone1=?,phone2=?,role=? where id=?";
		
		try (Connection con = getConnection(); var stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, member.name());
			stmt.setString(2, member.password());
			stmt.setString(3, member.phoneOne());
			stmt.setString(4, member.phoneTwo());
			stmt.setInt(5, member.role().ordinal());
			stmt.setInt(6,
					createAddress(member.address().city(), member.address().township(), member.address().street()));
			
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
