package com.jun.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.request.PrescriptionRequest;
import com.jun.hospital.response.PrescriptionResponse;
import com.jun.hospital.service.EnrollPrescriptionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PrescriptionEnrollController {
	
	@Autowired
	private final EnrollPrescriptionService prescriptionService;
	
	@PostMapping(value = "/prescription")
	public PrescriptionResponse prescriptionEnroll(@RequestBody PrescriptionRequest prescriptionRequest) {
		Prescription prescription = Prescription.of(prescriptionRequest);
		Prescription savedPrescription = prescriptionService.enrollOrUpdatePrescription(prescription);
		
		return PrescriptionResponse.of(savedPrescription);
	}

}











//@Getter 
//public class PrescriptionRequest {
//	
//	private Long DoctorSSN;
//	private Long paitentSSN;
//	private String companyName;
//	private String tradeName;
//	private LocalDate date;
//	private int quantity;
//}
