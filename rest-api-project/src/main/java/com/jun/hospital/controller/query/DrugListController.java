package com.jun.hospital.controller.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Drug;
import com.jun.hospital.response.DrugResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DrugListController {
	
	private final com.jun.hospital.service.query.SelectDrugService selectDrugService;

	@GetMapping(value = "company/{companyName}/drugs/make")
	public List<DrugResponse> getAllDrugsByCompanyName(@PathVariable("companyName") String companyName){
		List<Drug> drugs = selectDrugService.findDrugsByCompanyName(companyName);
		
		return drugs.stream()
					.map(DrugResponse::of)
					.toList();
	}
	

}
