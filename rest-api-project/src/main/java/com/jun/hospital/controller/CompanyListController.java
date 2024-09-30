package com.jun.hospital.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Company;
import com.jun.hospital.response.CompanyResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyListController {
	
	private final com.jun.hospital.service.query.SelectCompanyService selectCompanyService;
	
	@GetMapping(value = "company/drug/{tradeName}/make")
	public List<CompanyResponse> getCompanyByTradeName(@PathVariable("tradeName") String tradeName) {
		List<Company> companies = selectCompanyService.findByTradeName(tradeName);
		
		return companies.stream()
						.map(CompanyResponse::of)
						.toList();
	}

}
