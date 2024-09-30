package com.jun.hospital.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Reservation;
import com.jun.hospital.request.EnrollReservationRequest;
import com.jun.hospital.service.command.EnrollReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReservationErollController {
	
	private final EnrollReservationService enrollReservationService;
	
	@PostMapping(value = "/patient/{patientSsn}/doctor/{doctorSsn}/reservation")
	public ResponseEntity<Reservation.Id> enrollReservation(@PathVariable("patientSsn") Long patientSsn, @PathVariable("doctorSsn") Long doctorSsn,
			@RequestBody EnrollReservationRequest reservationRequest) {
		
		Reservation reservation = Reservation.of(reservationRequest, doctorSsn, patientSsn);
		
		Reservation savedReservation = enrollReservationService.enrollReservation(reservation);
		return new ResponseEntity<Reservation.Id>(savedReservation.getId(), HttpStatus.CREATED);
	}

}
