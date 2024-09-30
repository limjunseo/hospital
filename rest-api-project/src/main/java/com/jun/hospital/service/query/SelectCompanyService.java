package com.jun.hospital.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Company;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectCompanyService {
	
	private final SelectCompanyServiceImpl selectCompanyServiceImpl;
	
	public List<Company> findByTradeName(String tradeName) {
		return selectCompanyServiceImpl.findByTradeName(tradeName);
	}

}
