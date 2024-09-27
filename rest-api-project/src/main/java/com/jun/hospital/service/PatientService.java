 package com.jun.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Patient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PatientService {
	
	private final PatientServiceImpl patientServiceImpl;
	
	@Transactional
	public Patient findById(Long patientSSN) {
		return patientServiceImpl.findById(patientSSN);
	}
	

}
