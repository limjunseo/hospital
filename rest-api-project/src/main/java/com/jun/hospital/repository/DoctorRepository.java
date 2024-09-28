package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jun.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("SELECT d FROM primary_doctor pri "
			+ "JOIN doctor d "
			+ "WHERE pri.id.doctorSsn = d.doctorSsn "
			+ "AND pri.id.doctorSsn = :patientSsn")
	Doctor findPrimaryDoctorBypatientSsn(@Param("patientSsn") Long patientSsn);
}
