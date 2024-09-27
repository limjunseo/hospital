package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Drug.Id> {

}
