package com.jun.hospital.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
	private String name;
	private String speciality;
	private LocalDate exp_years;
	
}
