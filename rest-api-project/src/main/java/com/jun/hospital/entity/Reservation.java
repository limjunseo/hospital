package com.jun.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jun.hospital.request.EnrollReservationRequest;
import com.jun.hospital.request.NewReservationReqeust;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity @Getter @ToString
public class Reservation {
	
	@Embeddable @ToString @Getter @EqualsAndHashCode
	public static class Id implements Serializable {
		@Column(name = "DOCTOR_SSN")
		private Long doctorSsn;
		
		@Column(name = "PATIENT_SSN")
		private Long patientSsn;
		
		@Column(name = "RESERVATION_TIME")
		private LocalDateTime reservationTime;
		
		public static Reservation.Id create(Long doctorSsn, Long patientSsn, LocalDateTime reservationTime) {
			Reservation.Id id = new Reservation.Id();
			id.doctorSsn = doctorSsn;
			id.patientSsn = patientSsn;
			id.reservationTime = reservationTime;
			return id;
		}
	}
	
	@EmbeddedId
	private Reservation.Id id = new Reservation.Id();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_SSN", insertable = false, updatable = false)
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_SSN", insertable = false, updatable = false)
	private Patient patient;
	
	
	
	public static Reservation of(EnrollReservationRequest request, Long doctorSsn, Long patientSsn) {
		Reservation reservation = new Reservation();
		reservation.id.doctorSsn = doctorSsn;
		reservation.id.patientSsn = patientSsn;
		reservation.id.reservationTime = request.getReservationTime(); //reservation 객체의 기본 타입만 설정함.
		
		return reservation;
	}
	
	public static Reservation of(NewReservationReqeust request, Long doctorSsn, Long patientSsn) {
		Reservation reservation = new Reservation();
		reservation.id.doctorSsn = doctorSsn;
		reservation.id.patientSsn = patientSsn;
		reservation.id.reservationTime = request.getNewReservationTime(); //reservation 객체의 기본 타입만 설정함.
		
		return reservation;
	}
	
	//method
	public void reserve(Patient patient, Doctor doctor) {
		this.patient = patient; //객체 설정
		this.doctor = doctor;
	}
	
	
	
}
