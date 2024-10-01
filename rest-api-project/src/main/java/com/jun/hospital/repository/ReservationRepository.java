package com.jun.hospital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Reservation.Id>{
	
	@Query(value = "SELECT TIME(r.reservation_time) "
			+ "FROM Reservation r "
			+ "WHERE r.doctor_ssn = :doctorSsn "
			+ "AND DATE(r.reservation_time) = :searchDate", nativeQuery = true)
	public List<java.sql.Time> findAllTimesByDoctorAndDate(@Param("doctorSsn") Long doctorSsn, @Param("searchDate") LocalDate date);

}
