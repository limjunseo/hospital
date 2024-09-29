package com.jun.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Drug.Id> {

	@Query("SELECT d FROM Drug d "
			+ "JOIN Make m "
			+ "ON m.id.tradeName = d.id.tradeName " //drug와 make의 조인조건
			+ "WHERE m.id.companyName = :companyName")
	List<Drug> findDrugsByCompanyName(@Param("companyName") String companyName);
}
