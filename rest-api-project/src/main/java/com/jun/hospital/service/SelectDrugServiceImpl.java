package com.jun.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Drug;
import com.jun.hospital.repository.DrugRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class SelectDrugServiceImpl {
	
	private final DrugRepository drugRepository;

	public Drug findById(Drug.Id drugId) {
		return drugRepository.findById(drugId).get(); //예외처리필요
	}
	
	public List<Drug> findDrugsByCompanyName(String companyName) {
		return drugRepository.findDrugsByCompanyName(companyName);
	}

}
