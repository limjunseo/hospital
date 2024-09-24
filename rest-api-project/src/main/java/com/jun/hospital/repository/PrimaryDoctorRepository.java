package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.hospital.entity.PrimaryDoctor;

public interface PrimaryDoctorRepository extends JpaRepository<PrimaryDoctor, PrimaryDoctor.Id> {

}
