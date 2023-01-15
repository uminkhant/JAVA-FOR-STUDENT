package com.jdc.mkt.ds;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClassRoom {

	private Integer id;
	private String name;
	private int durations;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean isActive;
	
	public ClassRoom() {
		super();
	}
	
	
	public ClassRoom(String name, int durations, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.durations = durations;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}



	
	
}
