package com.jun.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity @Getter @ToString
public class Company {
	
	@Id
	private String companyName;
	
	private String phoneNum;

}
