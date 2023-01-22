package com.jdc.mkt.ds;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

	private int id;
	private String name;
	private String password;
	private Role role;
	private boolean isActive;
}
