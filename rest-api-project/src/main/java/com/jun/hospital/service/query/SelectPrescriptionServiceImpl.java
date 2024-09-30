package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.repository.PrescriptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectPrescriptionServiceImpl {
	
	@Autowired
	private final PrescriptionRepository prescriptionRepository;
	
	public List<Prescription> findAllPrescriptionsByDoctorSsn(Long doctorSsn) {
		return prescriptionRepository.findAllPrescriptionsByDoctorSsn(doctorSsn);
	}
	
	public List<Prescription> findAllPrescriptionsByPatientSsn(Long patientSsn) {
		return prescriptionRepository.findAllPrescriptionsByPatientSsn(patientSsn);
	}

}
