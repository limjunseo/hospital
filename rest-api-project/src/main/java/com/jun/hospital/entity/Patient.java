package com.jun.hospital.entity;

import com.jun.hospital.request.PatientRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity @Getter
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ssn;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_SSN")
	@NotNull
	private Doctor doctor;
	
	private int age;
	
	private String name;
	
	private String address;
	
	public void assignDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public static Patient of(PatientRequest patientRequest) {
		Patient patient = new Patient();
		patient.address = patientRequest.getAddress();
		patient.age = patientRequest.getAge(); 
		patient.name = patientRequest.getName();
		return patient;
		
	}

}
