package com.jun.hospital.service;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Drug;
import com.jun.hospital.entity.Drug.Id;
import com.jun.hospital.repository.DrugRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DrugServiceImpl {
	
	private final DrugRepository drugRepository;

	public Drug findById(Id drugId) {
		return drugRepository.findById(drugId).get(); //예외처리필요
	}

}
