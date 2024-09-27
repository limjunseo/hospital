package com.jun.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Prescription;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnrollPrescriptionService {
	
	private final EnrollPrescriptionServiceImpl prescriptionServiceImpl;
	
	@Transactional
	public Prescription enrollPrescription(Prescription prescription) {
		return prescriptionServiceImpl.enrollPrescription(prescription);
	}
}
