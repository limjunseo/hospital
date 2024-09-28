package com.jun.hospital.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor 
@AllArgsConstructor
public class PrescriptionRequest {
	
	private Long doctorSSN;
	private Long patient;
	private String companyName;
	private String tradeName;
	private int quantity;
}
