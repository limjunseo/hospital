package com.jun.hospital.service.command;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.Reservation;
import com.jun.hospital.repository.DoctorRepository;
import com.jun.hospital.repository.PatientRepository;
import com.jun.hospital.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReservationServiceImpl {
	
	private final ReservationRepository reservationRepository;
	
	private final PatientRepository patientRepository;
	
	private final DoctorRepository doctorRepository;
	
	public Reservation enrollReservation(Reservation reservation) {
		Reservation.Id id = reservation.getId();
		
		Doctor doctor = doctorRepository.findById(id.getDoctorSsn()).get(); //예외설정
		Patient patient = patientRepository.findById(id.getPatientSsn()).get();
		
		reservation.reserve(patient, doctor); //객체 설정
		Reservation savedReservation =  reservationRepository.saveAndFlush(reservation);
		return savedReservation;
	}
	
	public void deleteReservation(Reservation.Id reservationId) {
		reservationRepository.deleteReservation(reservationId.getDoctorSsn(), 
				reservationId.getPatientSsn(), 
				reservationId.getReservationTime());
	}
	

}
