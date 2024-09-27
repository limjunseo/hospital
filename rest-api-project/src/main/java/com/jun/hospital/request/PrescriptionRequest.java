package com.jun.hospital.request;

import java.time.LocalDate;

import lombok.Getter;

@Getter 
public class PrescriptionRequest {
	
	private Long doctorSSN;
	private Long patient;
	private String companyName;
	private String tradeName;
	private LocalDate date;
	private int quantity;
}
