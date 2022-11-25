package com.jdc.mkt.service;

import java.util.List;

import com.jdc.mkt.model.Member;

public interface MemberService {

	Member findMemberByNameAndPassword(String name,String password);
	List<Member> findMember();
	int createMember(Member member);
	
	public static MemberService getMeberService() {
		return new MemberServiceImpl();
	}
}
