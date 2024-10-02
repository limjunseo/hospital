package com.jun.hospital.controller.command;

import java.time.LocalDateTime;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Reservation;
import com.jun.hospital.request.EnrollReservationRequest;
import com.jun.hospital.service.command.ReservationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ReservationController {
	
	private final ReservationService reservationService;
	
	@PostMapping(value = "/patient/{patientSsn}/doctor/{doctorSsn}/reservation") //예약 등록
	public ResponseEntity<Reservation.Id> enrollReservation(@PathVariable("patientSsn") Long patientSsn, 
			@PathVariable("doctorSsn") Long doctorSsn,
			@RequestBody EnrollReservationRequest reservationRequest) {
		
		Reservation reservation = Reservation.of(reservationRequest, doctorSsn, patientSsn);
		
		Reservation savedReservation = reservationService.enrollReservation(reservation);
		return new ResponseEntity<Reservation.Id>(savedReservation.getId(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/patient/{patientSsn}/doctor/{doctorSsn}/reservation") //예약 취소
	public ResponseEntity<?> deleteReservation(@PathVariable("patientSsn") Long patientSsn,
												@PathVariable("doctorSsn") Long doctorSsn,
												@RequestParam("dateTime") LocalDateTime date) {

		Reservation.Id reservationId = Reservation.Id.create(doctorSsn, patientSsn, date);
		reservationService.deleteReservation(reservationId);
		
		return ResponseEntity.ok("Reservation deleted successfully");
	}

}
