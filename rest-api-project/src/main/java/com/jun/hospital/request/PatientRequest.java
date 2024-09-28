package com.jun.hospital.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
	
	private int age;
	private String name;
	private String address;

}
