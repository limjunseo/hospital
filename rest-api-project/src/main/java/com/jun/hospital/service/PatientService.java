 package com.jun.hospital.service;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Patient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PatientService {
	
	private final PatientServiceImpl patientServiceImpl;
	
	public Patient findById(Long patientSSN) {
		return patientServiceImpl.findById(patientSSN);
	}
	

}
