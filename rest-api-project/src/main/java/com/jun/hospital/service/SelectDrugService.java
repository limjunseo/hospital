package com.jun.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Drug;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectDrugService {
	
	private final SelectDrugServiceImpl drugServiceImpl;
	
	@Transactional
	public Drug findById(Drug.Id drugId) {
		return drugServiceImpl.findById(drugId);
	}

	@Transactional
	public List<Drug> findDrugsByCompanyName(String companyName) {
		return drugServiceImpl.findDrugsByCompanyName(companyName);
	}
}
