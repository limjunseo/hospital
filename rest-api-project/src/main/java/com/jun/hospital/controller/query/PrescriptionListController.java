package com.jun.hospital.controller.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.response.PrescriptionResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PrescriptionListController {
	
	private final com.jun.hospital.service.query.SelectPrescriptionService selectPrescriptionService;
	
	@GetMapping(value = "/doctor/{doctorSsn}/prescription")
	public java.util.List<PrescriptionResponse> getAllPrescriptionsByDoctorSsn(@PathVariable("doctorSsn") Long doctorSsn) {
		List<Prescription> prescriptions =  selectPrescriptionService.findAllPrescriptionsByDoctorSsn(doctorSsn);
		
		return prescriptions.stream()
							.map(PrescriptionResponse::of)
							.toList();
	}
	
	@GetMapping(value = "/patient/{patientSsn}/prescription")
	public List<PrescriptionResponse> getAllPrescriptionsByPatientSsn(@PathVariable("patientSsn") Long patientSsn) {
		List<Prescription> prescriptions = selectPrescriptionService.findAllPrescriptionsByPatientSsn(patientSsn);
		
		return prescriptions.stream()
							.map(PrescriptionResponse::of)
							.toList();
	}
	

}
