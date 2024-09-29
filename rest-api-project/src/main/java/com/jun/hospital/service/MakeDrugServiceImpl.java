package com.jun.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Company;
import com.jun.hospital.entity.Drug;
import com.jun.hospital.entity.Make;
import com.jun.hospital.repository.CompanyRepository;
import com.jun.hospital.repository.DrugRepository;
import com.jun.hospital.repository.MakeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MakeDrugServiceImpl {
	
	@Autowired
	private final CompanyRepository companyRepository;
	
	@Autowired
	private final DrugRepository drugRepository;
	
	@Autowired
	private final MakeRepository makeRepository;
	
	public Make.Id makeNewDrug(Make make, Drug drug) {
		String companyName = drug.getId().getCompanyName();
		Company company = companyRepository.findById(companyName).get(); //예외설정 필요
		
//		drug.madeBy(company); //객체 참조 설정
//		make.by(company); //객체 참조설정
		
		makeDrugByCompany(drug, make, company); //객체 참조 설정
		
		Drug savedDrug = drugRepository.save(drug);
		Make savedMake = makeRepository.save(make);
		
		return savedMake.getId();
		
	}
	
	private void makeDrugByCompany(Drug drug, Make make, Company company) {
		drug.madeBy(company);
		make.by(company);
	}

}
