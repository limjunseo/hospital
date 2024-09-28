package com.jun.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class DoctorServiceImpl {
	
	@Autowired
	private final DoctorRepository doctorRepository;
	
	public Doctor findById(Long doctorSSN) {
		return doctorRepository.findById(doctorSSN).get(); //예외처리 필요
	}
	
	public Doctor findPrimaryDoctorByPatientSsn(Long patientSsn) {
		Doctor savedDoctor =  doctorRepository.findPrimaryDoctorBypatientSsn(patientSsn);
		log.info("저장된 doctor : {}" , savedDoctor);
		return savedDoctor;
	}

}
