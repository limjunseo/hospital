package com.jun.hospital.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrescriptionResponse {
	
	private Long DoctorSSN;
	private Long PatientSSN;
	private String company;
	private String tradeName;
	private LocalDate date;

}
