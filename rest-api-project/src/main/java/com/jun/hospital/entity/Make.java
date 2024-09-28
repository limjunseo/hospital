package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity @Getter
public class Make { //회사가 만드는 약의 관계엔티티
	
	@EqualsAndHashCode @Getter
	public static class Id implements Serializable {
		@Column(name = "COMPANY_NAME") 
		private String companyName;
		
		@Column(name = "TRADE_NAME")
		private String tradeName;
	}
	
	@EmbeddedId
	private Make.Id id = new Id();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false) 
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "TRADE_NAME", referencedColumnName = "TRADE_NAME", insertable = false, updatable = false),
		@JoinColumn(name = "COMPANY_NAME", referencedColumnName = "COMPANY_NAME", insertable = false, updatable = false)
	}) 
	private Drug drug;
	

}
