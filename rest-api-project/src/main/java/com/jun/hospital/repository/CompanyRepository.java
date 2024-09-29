package com.jun.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{
	
	@Query("SELECT c FROM Company c "
			+ "JOIN Make m "
			+ "ON m.id.companyName = c.companyName "
			+ "WHERE m.id.tradeName = :tradeName")
	List<Company> findByTradeName(@Param("tradeName") String tradeName);
}
