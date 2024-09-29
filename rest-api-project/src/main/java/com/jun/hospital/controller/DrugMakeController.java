package com.jun.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Drug;
import com.jun.hospital.entity.Make;
import com.jun.hospital.request.DrugRequest;
import com.jun.hospital.service.MakeDrugService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DrugMakeController { //기존에 존재하는 회사가 새로운 약을 개발함
	
	private final MakeDrugService makeDrugService;
	
	@PostMapping(value = "/drug/company/{companyName}/make")
	public ResponseEntity<Make.Id> makeNewDrug(@PathVariable("companyName") String companyName, 
			@RequestBody DrugRequest drugRequest ) {
		
		Drug drug = Drug.of(drugRequest, companyName); //객체 설정은 아직 안된상태
		Make make = Make.of(companyName, drugRequest.getTradeName());
		
		Make.Id id = makeDrugService.makeNewDrug(make, drug);
		
		return new ResponseEntity<Make.Id>(id, HttpStatus.CREATED);
	}
	

}
