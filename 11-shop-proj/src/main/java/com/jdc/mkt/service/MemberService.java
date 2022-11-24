package com.jdc.mkt.service;

import com.jdc.mkt.model.Member;

public interface MemberService {

	Member findMember(String name,String password);
	int createMember(Member member);
	
	public static MemberService getMeberService() {
		return new MemberServiceImpl();
	}
}
