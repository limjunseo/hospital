package com.jun.hospital.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.request.PrescriptionRequest;
import com.jun.hospital.response.PrescriptionResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class PrescriptionEnrollController {
	
	@Autowired
	private final com.jun.hospital.service.command.EnrollPrescriptionService prescriptionService;
	
	@PostMapping(value = "/patient/doctor/prescription")
	public ResponseEntity<PrescriptionResponse> enrollPrescription(@RequestBody PrescriptionRequest prescriptionRequest) {
		Prescription prescription = Prescription.of(prescriptionRequest);
		Prescription newPrescription = prescriptionService.enrollOrUpdatePrescription(prescription);

		return new ResponseEntity<PrescriptionResponse>(PrescriptionResponse.of(newPrescription), HttpStatus.OK);
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
