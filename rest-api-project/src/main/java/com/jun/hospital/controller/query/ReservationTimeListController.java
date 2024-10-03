package com.jun.hospital.controller.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jun.hospital.entity.Reservation;
import com.jun.hospital.response.ReservationResponse;
import com.jun.hospital.service.query.SelectReservationTimeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReservationTimeListController {
	
	private final SelectReservationTimeService selectReservationTimeService;
	
	@GetMapping(value = "/doctor/{doctorSsn}/reservation/available-times")
	public List<LocalTime> getAvailableReservationTimes(@PathVariable("doctorSsn") Long doctorSsn, @RequestParam("date") LocalDate date) {
		return selectReservationTimeService.findAvailableReservationTimes(doctorSsn, date);
	}
	
	@GetMapping(value ="doctor/{doctorSsn}/reservation")
	public List<ReservationResponse> getReservationsByDoctorAndDate(@PathVariable("doctorSsn") Long doctorSsn, @RequestParam("date") LocalDate reservationDate) {
		List<Reservation> reservations = selectReservationTimeService.findReservationsByDoctorAndDate(doctorSsn, reservationDate);
		
		List<ReservationResponse> reservationResponses = reservations.stream()
																	.map(ReservationResponse::of)
																	.toList();
		
		return reservationResponses;
		
	}

}
