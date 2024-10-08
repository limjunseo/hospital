package com.jun.hospital.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.PrimaryDoctor;
import com.jun.hospital.repository.DoctorRepository;
import com.jun.hospital.repository.PatientRepository;
import com.jun.hospital.repository.PrimaryDoctorRepository;
import com.jun.hospital.service.query.SelectDoctorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollPatientServiceImpl {
	
	@Autowired
	private final SelectDoctorService doctorService;
	
	@Autowired
	private final PrimaryDoctorRepository primaryDoctorRepository;
	
	@Autowired
	private final PatientRepository patientRepository;
	
	@Autowired
	private final DoctorRepository doctorRepository;
	
	public PrimaryDoctor enrollPatient(Patient patient, Long doctorSSN) {
		Doctor doctor = doctorService.findById(doctorSSN);
		patient.assignDoctor(doctor);
		Patient savedPatient = patientRepository.save(patient);

		PrimaryDoctor primaryDoctor = PrimaryDoctor.assignPrimaryDoctor(savedPatient, doctor);
		PrimaryDoctor savedPrimaryDoctor = primaryDoctorRepository.save(primaryDoctor);	
		return savedPrimaryDoctor;
	}
	
	public PrimaryDoctor  enrollPatientAndDoctor(Patient patient, Doctor doctor) {
		Doctor savedDoctor = doctorRepository.save(doctor); //의사 등록
		patient.assignDoctor(savedDoctor); 
		
		Patient savedPatient = patientRepository.save(patient); //환자 등록
		
		PrimaryDoctor primaryDoctor = PrimaryDoctor.assignPrimaryDoctor(savedPatient, savedDoctor);
		PrimaryDoctor savedPrimaryDoctor = primaryDoctorRepository.save(primaryDoctor);
		return savedPrimaryDoctor;
		
	}
	

}
