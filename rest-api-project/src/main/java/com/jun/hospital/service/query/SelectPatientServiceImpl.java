package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Patient;
import com.jun.hospital.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectPatientServiceImpl {
	
	private final PatientRepository patientRepository;
	
	public Patient findById(Long PatientSSN) {
		return patientRepository.findById(PatientSSN).get(); //예외처리
	}
	
	public List<Patient> findAllPatientsByDoctorSsn(Long DoctorSsn) {
		return patientRepository.findPatientsByDoctorSsn(DoctorSsn);
	}

}
