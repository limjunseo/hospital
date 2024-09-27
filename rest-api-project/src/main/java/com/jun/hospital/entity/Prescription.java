package com.jun.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jun.hospital.request.PrescriptionRequest;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import lombok.Getter;

@Entity @Getter
public class Prescription {
	
	@Getter 
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
	
	@JoinColumn(name = "DOCTOR_SSN", insertable = false, updatable = false)
	private Doctor doctor;
	
	@JoinColumn(name = "PATIENT_SSN", insertable = false, updatable = false)
	private Patient patient;
	
	
	@JoinColumns({
		@JoinColumn(name = "COMPANY_NAME", referencedColumnName = "COMPANY_NAME", insertable = false, updatable = false ),
		@JoinColumn(name = "TRADE_NAME", referencedColumnName = "TRADE_NAME", insertable = false, updatable = false)
	})
	private Drug drug;

	private LocalDate date;
	
	private int quantity;
	
	public static Prescription of(PrescriptionRequest prescriptionRequest) {
		Prescription prescription = new Prescription();
		
		prescription.id.doctorSSN = prescriptionRequest.getDoctorSSN();
		prescription.id.patientSSN = prescriptionRequest.getPaitentSSN();
		prescription.id.companyName = prescriptionRequest.getCompanyName();
		prescription.id.tradeName = prescriptionRequest.getTradeName();
		prescription.date = prescriptionRequest.getDate();
		prescription.quantity = prescriptionRequest.getQuantity();
		
		return prescription;
	}
	
	
	//method
	public void prescribe(Doctor doctor, Patient patient, Drug drug) {
		this.doctor = doctor;
		this.patient = patient;
		this.drug = drug;
	}

	
	
	
}
