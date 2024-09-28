package com.jun.hospital.response;

import com.jun.hospital.entity.Patient;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor
public class PatientResponse {
	
	private Long patientSsn;
	
	private int age;
	
	private String name;
	
	private String address;
	
	public static PatientResponse of(Patient patient) {
		PatientResponse patientResponse = new PatientResponse();
		patientResponse.age = patient.getAge();
		patientResponse.address = patient.getAddress();
		patientResponse.name = patient.getName();
		patientResponse.patientSsn = patient.getSsn();
		
		return patientResponse;
	}

}







//
//private Long ssn;
//
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "DOCTOR_SSN")
//@NotNull
//private Doctor doctor;
//
//private int age;
//
//private String name;
//
//private String address;