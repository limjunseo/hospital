package com.jun.hospital.response;

import java.time.LocalDate;

import com.jun.hospital.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
public class DoctorResponse {
	
	private Long doctorSsn;
	private String name;
	private String speciality;
	private LocalDate exp_years;

	public static DoctorResponse of(Doctor doctor) {
		DoctorResponse doctorResponse = new  DoctorResponse();
		doctorResponse.doctorSsn = doctor.getDoctorSsn();
		doctorResponse.exp_years = doctor.getExp_years();
		doctorResponse.name = doctor.getName();
		doctorResponse.speciality = doctor.getSpeciality();
		
		return doctorResponse;
	}
}



//private Long doctorSsn;
//
//private String name;
//
//private String speciality;
//
//private LocalDate exp_years;
//
//public static Doctor of(DoctorRequest doctorRequest) {
//	Doctor doctor = new Doctor();
//	doctor.speciality = doctorRequest.getSpeciality();
//	doctor.name = doctorRequest.getName();
//	doctor.exp_years = doctorRequest.getExp_years();
//	
//	return doctor;
//}