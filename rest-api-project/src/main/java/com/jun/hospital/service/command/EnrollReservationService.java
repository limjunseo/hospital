package com.jun.hospital.service.command;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Reservation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnrollReservationService {
	
	private final EnrollReservationServiceImpl enrollReservationServiceImpl;
	
	public Reservation enrollReservation(Reservation reservation) {
		return enrollReservationServiceImpl.enrollReservation(reservation);
	}

}
