package com.jdc.mkt.model;

public record Member(int id, String name, String password, String phoneOne, String phoneTwo, Address address,
		MRole role) {

}
