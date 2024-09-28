package com.jun.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jun.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("SELECT p FROM PrimaryDoctor pri, Patient p "
			+ "WHERE pri.patient_ssn = p.ssn "
			+ "AND pri.doctor_ssn = :doctorSsn")
	List<Patient> findPatientsByDoctorSsn(@Param("doctorSsn") Long doctorSsn);

}
