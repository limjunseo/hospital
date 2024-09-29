package com.jun.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.repository.PrescriptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class selectPrescriptionServiceImpl {
	
	@Autowired
	private final PrescriptionRepository prescriptionRepository;
	
	public List<Prescription> findAllPrescriptionsByDoctorSsn(Long doctorSsn) {
		return prescriptionRepository.findAllPrescriptionsByDoctorSsn(doctorSsn);
	}

}
