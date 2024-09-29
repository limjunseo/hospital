package com.jun.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity 
public class Pharmacy {
	
	@Id
	private String name;
	
	private String address;
	
	private String phoneNum;
	
	
}
