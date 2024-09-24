package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
