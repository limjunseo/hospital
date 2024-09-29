package com.jun.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Prescription;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class selectPrescriptionService {

	private final selectPrescriptionServiceImpl selectPrescriptionServiceImpl;
	
	public List<Prescription> findAllPrescriptionsByDoctorSsn(Long doctorSsn) {
		return selectPrescriptionServiceImpl.findAllPrescriptionsByDoctorSsn(doctorSsn);
	}
}
