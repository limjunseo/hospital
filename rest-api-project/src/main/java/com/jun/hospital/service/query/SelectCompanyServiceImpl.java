package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Company;
import com.jun.hospital.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class SelectCompanyServiceImpl {

	private final CompanyRepository companyRepository;
	
	List<Company> findByTradeName(String tradeName) {
		return companyRepository.findByTradeName(tradeName);

	}
}
