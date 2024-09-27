package com.jun.hospital.service;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Drug;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DrugService {
	
	private final DrugServiceImpl drugServiceImpl;
	
	public Drug findById(Drug.Id drugId) {
		return drugServiceImpl.findById(drugId);
	}

}
