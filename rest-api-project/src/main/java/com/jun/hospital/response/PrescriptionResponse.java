package com.jun.hospital.response;

import java.time.LocalDate;

import com.jun.hospital.entity.Prescription;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionResponse {
	
	private Long doctorSSN;
	private Long patientSSN;
	private String company;
	private String tradeName;
	private LocalDate date;

	public static PrescriptionResponse of(Prescription prescription) {
		Prescription.Id id = prescription.getId();
		PrescriptionResponse prescriptionResponse = new PrescriptionResponse();
		
		prescriptionResponse.doctorSSN = id.getDoctorSSN();
		prescriptionResponse.patientSSN = id.getPatientSSN();
		prescriptionResponse.tradeName = id.getTradeName();
		prescriptionResponse.company = id.getCompanyName();
		prescriptionResponse.date = prescription.getDate();
		
		return prescriptionResponse;
	}
}
