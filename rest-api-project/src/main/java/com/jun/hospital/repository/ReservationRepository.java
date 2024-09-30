package com.jun.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jun.hospital.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Reservation.Id>{

}
