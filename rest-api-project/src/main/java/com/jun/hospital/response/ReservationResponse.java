package com.jun.hospital.response;

import java.time.LocalTime;

import com.jun.hospital.entity.Reservation;

public class ReservationResponse {
	
	private Long doctorSsn;
	
	private Long patientSsn;
	
	private LocalTime reservationTime;
	
	public static ReservationResponse of(Reservation reservation) {
		Reservation.Id id = reservation.getId();
		ReservationResponse reservationResponse = new ReservationResponse();
		
		reservationResponse.doctorSsn = id.getDoctorSsn();
		reservationResponse.patientSsn = id.getPatientSsn();
		reservationResponse.reservationTime = id.getReservationTime().toLocalTime();
		
		return reservationResponse;
		
	}

}
