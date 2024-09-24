package com.jun.hospital.entity;

import java.time.LocalDate;

import com.jun.hospital.dto.DoctorRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity @Getter
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOCTOR_SSN")
	private Long ssn;
	
	private String name;
	
	private String speciality;
	
	private LocalDate exp_years;

	public static Doctor of(DoctorRequest doctorRequest) {
		Doctor doctor = new Doctor();
		doctor.speciality = doctorRequest.getSpeciality();
		doctor.name = doctorRequest.getName();
		doctor.exp_years = doctorRequest.getExp_years();
		
		return doctor;
	}
}
