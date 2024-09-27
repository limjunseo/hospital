package com.jun.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Doctor;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class DoctorService {
	
	@Autowired
	private final DoctorServiceImpl doctorServiceImpl;
	
	public Doctor findById(Long doctorSSN) {
		return doctorServiceImpl.findById(doctorSSN);
	}

}
