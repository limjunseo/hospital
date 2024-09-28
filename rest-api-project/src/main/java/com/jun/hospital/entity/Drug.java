package com.jun.hospital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.ToString;

@Entity @Getter
public class Drug {
	
	@Embeddable @ToString @Getter
	public static class Id implements Serializable{
		@Column(name = "TRADE_NAME")
		private String tradeName;
		
		@Column(name = "COMPANY_NAME")
		private String companyName;
		
		public static Drug.Id create(String tradeName, String companyName) {
			Drug.Id id = new Drug.Id();
			id.tradeName = tradeName;
			id.companyName = companyName;
			return id;
		}
	}
	
	
	@EmbeddedId
	private Drug.Id id = new Drug.Id();
	
	@ManyToOne
	@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false)
	private Company company;

	private String formula;

}
