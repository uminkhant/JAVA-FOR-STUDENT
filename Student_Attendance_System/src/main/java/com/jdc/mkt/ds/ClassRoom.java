package com.jdc.mkt.ds;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClassRoom {

	private Integer id;
	private String name;
	private int fees;
	private int durations;
	private LocalDate startDate;
	private LocalDate endDate;
	private Course course;
	private boolean isActive;

	
}
