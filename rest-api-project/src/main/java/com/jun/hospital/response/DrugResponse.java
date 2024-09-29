package com.jun.hospital.response;

import com.jun.hospital.entity.Drug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DrugResponse {
	
	private String companyName;
	private String formula;
	private String tradeName;
	
	public static DrugResponse of(Drug drug) {
		DrugResponse drugResponse = new DrugResponse();
		drugResponse.companyName = drug.getId().getCompanyName();
		drugResponse.tradeName = drug.getId().getTradeName();

		drugResponse.formula = drug.getFormula();
		
		return drugResponse;
	}
	
}



//
//@EmbeddedId
//private Drug.Id id = new Drug.Id();
//
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false)
//private Company company;
//
//private String formula;