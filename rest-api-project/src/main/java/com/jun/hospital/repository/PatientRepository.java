package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
