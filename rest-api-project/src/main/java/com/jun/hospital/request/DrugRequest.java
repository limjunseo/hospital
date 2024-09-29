package com.jun.hospital.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DrugRequest {
	
	private String formula;
	
	private String tradeName;

}



//@EmbeddedId
//private Drug.Id id = new Drug.Id();
//
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "COMPANY_NAME", insertable = false, updatable = false)
//private Company company;
//
//private String formula;