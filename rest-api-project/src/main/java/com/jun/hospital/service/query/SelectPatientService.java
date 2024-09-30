 package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Patient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectPatientService {
	
	private final SelectPatientServiceImpl patientServiceImpl;
	
	@Transactional
	public Patient findById(Long patientSSN) {
		return patientServiceImpl.findById(patientSSN);
	}
	

	@Transactional
	public List<Patient> findAllPatientsByDoctorSsn(Long DoctorSsn) {
		return patientServiceImpl.findAllPatientsByDoctorSsn(DoctorSsn);
	}
}
