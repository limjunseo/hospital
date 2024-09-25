package com.jun.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.PrimaryDoctor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service 
public class EnrollPatientService {
	
	private final EnrollPatientServiceImpl enrollPatientServiceImpl;
	
	@Transactional //기존 의사와 환자 등록
	public PrimaryDoctor.Id enrollPatient(Patient patient, Long doctorSSN) {
		return enrollPatientServiceImpl.enrollPatient(patient, doctorSSN);	
	}
	
	@Transactional //새로운 의사와 환자 등록
	public PrimaryDoctor.Id enrollPatientAndDoctor(Patient patient, Doctor doctor) {
		return enrollPatientServiceImpl.enrollPatientAndDoctor(patient, doctor);
	}
	

}
