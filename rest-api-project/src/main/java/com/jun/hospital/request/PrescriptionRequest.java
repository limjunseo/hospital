package com.jun.hospital.request;

import java.time.LocalDate;

import lombok.Getter;

@Getter 
public class PrescriptionRequest {
	
	private Long DoctorSSN;
	private Long paitentSSN;
	private String companyName;
	private String tradeName;
	private LocalDate date;
	private int quantity;
}
