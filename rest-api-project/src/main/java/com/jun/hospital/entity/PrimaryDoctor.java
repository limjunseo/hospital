package com.jun.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PrimaryDoctor {
	
	@OneToOne
	@Column(name = "patient_ssn")
	private Patient patient;
	
	@OneToMany
	@Column(name = "doctor_ssn")
	private Doctor doctor;
	
	

}
