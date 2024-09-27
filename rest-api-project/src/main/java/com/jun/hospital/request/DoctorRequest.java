package com.jun.hospital.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
	private String name;
	private String speciality;
	private LocalDate exp_years;
	
}
