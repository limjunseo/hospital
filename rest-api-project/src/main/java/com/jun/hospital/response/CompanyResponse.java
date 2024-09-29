package com.jun.hospital.response;

import com.jun.hospital.entity.Company;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter 
public class CompanyResponse {
	
	private String companyName;
	
	private String phoneNum;
	
	public static CompanyResponse of(Company company) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.companyName = company.getCompanyName();
		companyResponse.phoneNum = company.getPhoneNum();
		
		return companyResponse;
	}

}
