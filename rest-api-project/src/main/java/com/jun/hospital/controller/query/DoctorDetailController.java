package com.jun.hospital.controller.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.response.DoctorResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class DoctorDetailController {
	
	private final com.jun.hospital.service.query.SelectDoctorService doctorService;
	
	@GetMapping(value = "/patient/{patientSsn}/doctor/primaryDoctor")
	public DoctorResponse getAllPatientsByDoctorSsn(@PathVariable("patientSsn") Long patientSsn) {
		Doctor doctor = doctorService.findPrimaryDoctorByPatientSsn(patientSsn);
		
		return DoctorResponse.of(doctor);
	}

}





