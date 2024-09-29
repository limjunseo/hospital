package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Make;

@Repository
public interface MakeRepository extends JpaRepository<Make, Make.Id>{

}
