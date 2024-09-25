package com.jun.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class EnrollRequest {
	private PatientRequest patientRequest;
	
	private DoctorRequest doctorRequest;

}
