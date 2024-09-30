package com.jun.hospital.service.command;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Drug;
import com.jun.hospital.entity.Make;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MakeDrugService {
	
	private final MakeDrugServiceImpl makeDrugServiceImpl;
	

	public Make.Id makeNewDrug(Make make, Drug drug) {
		return makeDrugServiceImpl.makeNewDrug(make, drug);
	}
}
