package com.jun.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Doctor;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class DoctorService {
	
	@Autowired
	private final DoctorServiceImpl doctorServiceImpl;
	
	@Transactional
	public Doctor findById(Long doctorSSN) {
		return doctorServiceImpl.findById(doctorSSN);
	}
	
	@Transactional
	public Doctor findPrimaryDoctorByPatientSsn(Long patientSsn) {
		return doctorServiceImpl.findPrimaryDoctorByPatientSsn(patientSsn);
	}

}
