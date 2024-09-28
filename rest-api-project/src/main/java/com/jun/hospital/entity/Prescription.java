package com.jun.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jun.hospital.request.PrescriptionRequest;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;

//의사가 환자에게 어떤 약을 처방하는 처방전 관계엔티티
@Entity @Getter
public class Prescription {
	
	@Getter @EqualsAndHashCode
	public static class Id implements Serializable {
		@Column(name = "DOCTOR_SSN")
		private Long doctorSsn;
		
		@Column(name = "PATIENT_SSN")
		private Long patientSsn;
		
		@Column(name = "COMPANY_NAME")
		private String companyName;
		
		@Column(name = "TRADE_NAME") //약 이름
		private String tradeName;
		
	}
	
	@EmbeddedId
	private Prescription.Id id = new Id();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_SSN", insertable = false, updatable = false)
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_SSN", insertable = false, updatable = false)
	private Patient patient;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "COMPANY_NAME", referencedColumnName = "COMPANY_NAME", insertable = false, updatable = false ),
		@JoinColumn(name = "TRADE_NAME", referencedColumnName = "TRADE_NAME", insertable = false, updatable = false)
	})
	private Drug drug;

	private LocalDate prescribeDate;
	
	private int quantity;
	
	public static Prescription of(PrescriptionRequest prescriptionRequest) {
		Prescription prescription = new Prescription();
		
		prescription.id.doctorSsn = prescriptionRequest.getDoctorSsn();
		prescription.id.patientSsn = prescriptionRequest.getPatientSsn();
		prescription.id.companyName = prescriptionRequest.getCompanyName();
		prescription.id.tradeName = prescriptionRequest.getTradeName();
		prescription.quantity = prescriptionRequest.getQuantity();
		prescription.prescribeDate = LocalDate.now();
		
		return prescription;
	}
	
	
	
	//method
	public void prescribe(Doctor doctor, Patient patient, Drug drug) {
		this.doctor = doctor;
		this.patient = patient;
		this.drug = drug;
	}
	
	public void updatePrescription(LocalDate prescribeDate, int quantity) {
		this.prescribeDate = prescribeDate;
		this.quantity = quantity;
	}

	
	
	
}
