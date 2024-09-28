package com.jun.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Prescription;
import com.jun.hospital.repository.PrescriptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnrollPrescriptionService {
	
	
	@Autowired
	private final PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private final EnrollPrescriptionServiceImpl prescriptionServiceImpl;
	
	@Transactional
	public Prescription enrollOrUpdatePrescription(Prescription prescription) {
		Optional<Prescription> existingPrescription = prescriptionRepository.findById(prescription.getId());

		return (existingPrescription.isPresent()) ? 
				prescriptionServiceImpl.updatePrescription(existingPrescription.get(), prescription.getQuantity()) : 
					prescriptionServiceImpl.enrollPrescription(prescription);
			
		//기존 처방전이 있으면 날짜만 persist context에서 업데이트, 없으면 새로운 처방전 등록.
	}
}
