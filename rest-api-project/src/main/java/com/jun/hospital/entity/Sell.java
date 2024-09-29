package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.ToString;

@Entity 
public class Sell { //약국에서 파는 약의 관계를 나타내는 엔티티
	
	@Embeddable @Getter @ToString
	public static class Id implements Serializable {
		
		@Column(name = "PHARMACY_NAME")
		private String pharmacyName;
		
		@Column(name = "TRADE_NAME")
		private String tradeName;
		
		@Column(name = "COMPANY_NAME")
		private String companyName;
		
	}
	
	@EmbeddedId
	private Sell.Id id = new Sell.Id();
	
	@ManyToOne
	@JoinColumn(name = "PHARMACY_NAME", insertable = false, updatable = false)
	private Pharmacy pharmacy;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "TRADE_NAME", referencedColumnName = "TRADE_NAME", insertable = false, updatable = false),
		@JoinColumn(name = "COMPANY_NAME", referencedColumnName = "COMPANY_NAME", insertable = false, updatable = false)
	})
	private Drug drug;
	
	private int price;
}
