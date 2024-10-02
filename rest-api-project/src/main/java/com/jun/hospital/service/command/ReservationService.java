package com.jun.hospital.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jun.hospital.entity.Reservation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {
	
	private final ReservationServiceImpl reservationServiceImpl;
	
	
	@Transactional
	public Reservation enrollReservation(Reservation reservation) {
		return reservationServiceImpl.enrollReservation(reservation);
	}
	
	@Transactional
	public void deleteReservation(Reservation.Id reservationId) {
		reservationServiceImpl.deleteReservation(reservationId);
	}

}
