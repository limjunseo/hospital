package com.jun.hospital.entity;

import java.io.Serializable;

import com.jun.hospital.request.DrugRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity @Getter
public class Drug {
	
	@Embeddable @ToString @Getter @EqualsAndHashCode
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false)
	private Company company;

	private String formula;
	
	public static Drug of(DrugRequest drugRequest, String companyName) {
		Drug drug = new Drug();
		drug.id.companyName = companyName;
		drug.id.tradeName = drugRequest.getTradeName();
		drug.formula = drugRequest.getFormula();
		
		return drug;
	}
	
	public void madeBy(Company company) {
		this.company = company;
	}

}
