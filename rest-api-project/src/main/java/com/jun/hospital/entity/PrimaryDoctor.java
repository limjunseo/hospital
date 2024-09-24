package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PrimaryDoctor {
	
	@Embeddable
	public static class Id implements Serializable {
		@Column(name = "PATIENT_SSN")
		private Long patientSSN;
		
		@Column(name = "DOCTOR_SSN")
		private Long doctorSSN;
	}
	
	@EmbeddedId
	private Id id = new Id();
	
	@OneToOne
	@JoinColumn(
			name = "PATIENT_SSN",
			insertable = false, updatable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(
			name = "DOCTOR_SSN",
			insertable = false, updatable = false)
	private Doctor doctor;
	
	public PrimaryDoctor() {
		
	}
	
	

}
