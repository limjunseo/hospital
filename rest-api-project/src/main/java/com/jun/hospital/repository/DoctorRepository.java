package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jun.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("SELECT d FROM PrimaryDoctor pri "
			+ "JOIN Doctor d "
			+ "ON pri.id.doctorSsn = d.doctorSsn "
			+ "WHERE pri.id.patientSsn = :patientSsn")
	Doctor findPrimaryDoctorBypatientSsn(@Param("patientSsn") Long patientSsn);
}
