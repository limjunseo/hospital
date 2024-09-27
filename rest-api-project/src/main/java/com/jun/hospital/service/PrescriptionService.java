package com.jun.hospital.service;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Prescription;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrescriptionService {
	
	private final PrescriptionServiceImpl prescriptionServiceImpl;
	
	public Prescription enrollPrescription(Prescription prescription) {
		return prescriptionServiceImpl.enrollPrescription(prescription);
	}
}
