package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Prescription;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectPrescriptionService {

	private final SelectPrescriptionServiceImpl selectPrescriptionServiceImpl;
	
	@Transactional
	public List<Prescription> findAllPrescriptionsByDoctorSsn(Long doctorSsn) {
		return selectPrescriptionServiceImpl.findAllPrescriptionsByDoctorSsn(doctorSsn);
	}
	
	@Transactional
	public List<Prescription> findAllPrescriptionsByPatientSsn(Long patientSsn) {
		return selectPrescriptionServiceImpl.findAllPrescriptionsByPatientSsn(patientSsn);
	}
}
