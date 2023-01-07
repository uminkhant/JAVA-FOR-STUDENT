package com.jdc.mkt.ds;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Subject {

	private Integer id;
	private String course;
	private double fees;
	private LocalDate start_dt;
	private LocalDate end_dt;
	private List<String>contents;
	private String descriptions;
		
	
}
