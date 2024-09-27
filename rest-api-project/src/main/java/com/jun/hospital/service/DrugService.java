package com.jun.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Drug;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DrugService {
	
	private final DrugServiceImpl drugServiceImpl;
	
	@Transactional
	public Drug findById(Drug.Id drugId) {
		return drugServiceImpl.findById(drugId);
	}

}
