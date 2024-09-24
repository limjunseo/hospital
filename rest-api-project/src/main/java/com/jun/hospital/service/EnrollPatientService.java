package com.jun.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.PrimaryDoctor;
import com.jun.hospital.repository.PrimaryDoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollPatientService {
	
	@Autowired
	private final DoctorService doctorService;
	
	@Autowired
	private final PrimaryDoctorRepository primaryDoctorRepository;
	
	@Transactional
	public PrimaryDoctor.Id enrollPatient(Patient patient, Long doctorSSN) {
		Doctor doctor = doctorService.findById(doctorSSN);
		PrimaryDoctor primaryDoctor = PrimaryDoctor.assignPrimaryDoctor(patient, doctor);
		PrimaryDoctor savedPrimaryDoctor = primaryDoctorRepository.save(primaryDoctor);	
		return savedPrimaryDoctor.getId();
	}
	

}
