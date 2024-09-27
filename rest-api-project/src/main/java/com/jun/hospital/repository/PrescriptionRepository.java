package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.hospital.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Prescription.Id> {
	
}
