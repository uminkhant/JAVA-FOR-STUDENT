package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Member;

public interface MemberService {

	Member findMemberByNameAndPassword(String name,String password);
	void deleteMemberById(int id);
	List<Member> findMember(int id,String name);
	int createMember(Member member);
	
	public static MemberService getMeberService() {
		return new MemberServiceImpl();
	}
}
