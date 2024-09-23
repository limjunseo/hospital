package com.jun.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ssn;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "doctor_ssn")
	private Doctor doctor;
	
	

}
