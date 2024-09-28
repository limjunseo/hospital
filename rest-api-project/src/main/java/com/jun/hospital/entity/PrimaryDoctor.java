package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

//의사와 환자의 주치의 관계엔티티
@Entity @Getter
public class PrimaryDoctor {
	
	@Embeddable @ToString @Getter @EqualsAndHashCode
	public static class Id implements Serializable {
		@Column(name = "PATIENT_SSN")
		private Long patientSsn;
		
		@Column(name = "DOCTOR_SSN")
		private Long doctorSsn;
	}
	
	@EmbeddedId
	private Id id = new Id();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name = "PATIENT_SSN",
			insertable = false, updatable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name = "DOCTOR_SSN",
			insertable = false, updatable = false)
	private Doctor doctor;
	
	protected PrimaryDoctor() {
		 
	}
	
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	private void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public static PrimaryDoctor assignPrimaryDoctor(Patient patient , Doctor doctor) {
		PrimaryDoctor primaryDoctor = new PrimaryDoctor();
		
		primaryDoctor.id.doctorSsn = doctor.getDoctorSsn();
		primaryDoctor.id.patientSsn = patient.getSsn();
		primaryDoctor.setDoctor(doctor);
		primaryDoctor.setPatient(patient);
		return primaryDoctor;
	}
	
	

}
