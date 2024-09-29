package com.jun.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Patient;
import com.jun.hospital.response.PatientResponse;
import com.jun.hospital.service.PatientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PatientListController {
	
	private final PatientService patientService;
	

	@GetMapping(value = "patient/doctor/{doctorSsn}")
	public java.util.List<PatientResponse> getAllPatientsByDoctorSsn(@PathVariable(name = "doctorSsn") Long doctorSsn) {
		List<Patient> patients =  patientService.findAllPatientsByDoctorSsn(doctorSsn);
		
		List<PatientResponse> patientResponses = 
				patients.stream()
						.map(PatientResponse::of)
						.toList();
		
		return patientResponses;
	}
}



//@GetMapping("/patients")
//public ResponseEntity<List<PatientResponse>> getAllPatients() {
//    List<PatientResponse> patients = patientService.findAllPatients();
//    if (patients.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    return new ResponseEntity<>(patients, HttpStatus.OK);
//}