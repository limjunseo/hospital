package com.jun.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jun.hospital.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Prescription.Id> {
	
	@Query("SELECT p FROM Presciption p "
			+ "WHERE p.id.doctorSsn = :doctorSsn")
	List<Prescription> findAllPrescriptionsByDoctorSsn(@Param("doctorSsn") Long doctorSsn);
}
