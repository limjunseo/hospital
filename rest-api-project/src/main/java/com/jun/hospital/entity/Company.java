package com.jun.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity @Getter
public class Company {
	
	@Id
	private String companyName;

}
