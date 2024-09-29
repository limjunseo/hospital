package com.jun.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity @Getter
public class Contract {
	
	@Embeddable @Getter
	public static class Id implements Serializable {
		@Column(name = "COMPANY_NAME")
		private String companyName;
		
		@Column(name = "PHARMACY_NAME")
		private String pharmacyName;
	}
	
	@EmbeddedId
	private Contract.Id id = new Contract.Id();
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String text;
	
	private String supervisor;
	
	@ManyToOne
	@JoinColumn(name = "PHARMACY_NAME", insertable = false, updatable = false)
	private Pharmacy pharmacy;
	
	@ManyToOne
	@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false)
	private Company company;
	
	
	
}
