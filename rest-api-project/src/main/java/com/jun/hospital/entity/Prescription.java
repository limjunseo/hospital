package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity @Getter
public class Prescription {
	
	public static class Id implements Serializable {
		@Column(name = "DOCTOR_SSN")
		private Long doctorSSN;
		
		@Column(name = "PATIENT_SSN")
		private Long patientSSN;
		
		@Column(name = "COMPANY_NAME")
		private String companyName;
		
		@Column(name = "TRADE_NAME") //약 이름
		private String tradeName;
		
	}
	
	@EmbeddedId
	private Prescription.Id id = new Id();
	
	@Column(name = "DOCTOR_SSN", insertable = false, updatable = false)
	private Doctor doctor;
	
	@Column(name = "PATIENT_SSN", insertable = false, updatable = false)
	private Patient patient;
	
	@Column(name = "COMPANY_NAME")
	private Company company;
	
	@Column(name = "TRADE_NAME")
	private 

}
