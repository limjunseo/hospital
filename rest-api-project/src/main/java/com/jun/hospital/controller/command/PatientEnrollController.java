package com.jun.hospital.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.PrimaryDoctor;
import com.jun.hospital.request.DoctorRequest;
import com.jun.hospital.request.EnrollRequest;
import com.jun.hospital.request.PatientRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController 
public class PatientEnrollController {
	
	private final com.jun.hospital.service.command.EnrollPatientServiceImpl enrollPatientService;
	
	@PostMapping(value = "/patient/doctor/{doctorSsn}/primaryDoctor") //기존 DB에 존재하는 의사와 새로운 환자의 관계를 등록
	public ResponseEntity<PrimaryDoctor.Id> enrollPatient(
			@PathVariable(name = "doctorSsn") Long doctorSSN, 
			@RequestBody PatientRequest patientRequest) {
		
		Patient patient = Patient.of(patientRequest);
		PrimaryDoctor savedPrimaryDoctor = enrollPatientService.enrollPatient(patient, doctorSSN);
		PrimaryDoctor.Id id = savedPrimaryDoctor.getId();
		return new ResponseEntity<PrimaryDoctor.Id>(id , HttpStatus.CREATED);
	}   
	
	@PostMapping(value = "/patient/doctor/primaryDoctor") //새로운 의사와 새로운 환자의 관계를 등록
	public ResponseEntity<PrimaryDoctor.Id> enrollPatientAndDoctor(
			@RequestBody EnrollRequest enrollRequest) {
		
		PatientRequest patientRequest = enrollRequest.getPatientRequest();
		DoctorRequest doctorRequest = enrollRequest.getDoctorRequest();
		
		Patient patient = Patient.of(patientRequest);
		Doctor doctor = Doctor.of(doctorRequest);
		PrimaryDoctor savedPrimaryDoctor = enrollPatientService.enrollPatientAndDoctor(patient, doctor);
		PrimaryDoctor.Id id = savedPrimaryDoctor.getId();
		return new ResponseEntity<PrimaryDoctor.Id>(id, HttpStatus.CREATED);
	}
	
	

}
