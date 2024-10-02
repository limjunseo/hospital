package com.jun.hospital.controller.command;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Reservation;
import com.jun.hospital.request.EnrollReservationRequest;
import com.jun.hospital.service.command.ReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReservationController {
	
	private final ReservationService reservationService;
	
	@PostMapping(value = "/patient/{patientSsn}/doctor/{doctorSsn}/reservation")
	public ResponseEntity<Reservation.Id> enrollReservation(@PathVariable("patientSsn") Long patientSsn, @PathVariable("doctorSsn") Long doctorSsn,
			@RequestBody EnrollReservationRequest reservationRequest) {
		
		Reservation reservation = Reservation.of(reservationRequest, doctorSsn, patientSsn);
		
		Reservation savedReservation = reservationService.enrollReservation(reservation);
		return new ResponseEntity<Reservation.Id>(savedReservation.getId(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/reservation/{reservationId}") 
	public ResponseEntity<?> deleteReservation(@Param("reservationId") Reservation.Id reservationId) {
		reservationService.deleteReservation(reservationId);
		
		return ResponseEntity.ok("Reservation deleted successfully");
	}

}
