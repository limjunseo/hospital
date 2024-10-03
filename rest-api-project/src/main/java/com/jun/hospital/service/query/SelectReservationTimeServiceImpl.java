package com.jun.hospital.service.query;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Reservation;
import com.jun.hospital.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class SelectReservationTimeServiceImpl {
	
	private final ReservationRepository reservationRepository;
		
	public List<LocalTime> findAvailableReservationTimes(Long doctorSsn, LocalDate date) {
		List<LocalTime> reservedTimes = reservationRepository.findReservedTimesByDoctorAndDate(doctorSsn, date)
				.stream()
				.map(time -> time.toLocalTime())
				.toList();
		
		List<LocalTime> allTimes = generateAllTimes(LocalTime.of(9, 0), LocalTime.of(17, 0));
		
		
		return allTimes.stream()
						.filter(t -> !reservedTimes.contains(t))
						.toList();
	}

	
	public List<Reservation> findReservationsByDoctorAndDate(Long doctorSsn, LocalDate reservationDate) {
		return reservationRepository.findReservationsByDoctorAndDate(doctorSsn, reservationDate);
	}

	
	private List<LocalTime> generateAllTimes(LocalTime startTime, LocalTime endTime) {
		final Duration interval = Duration.ofMinutes(30);
		
		List<LocalTime> lists = new ArrayList<LocalTime>();
		LocalTime current = startTime;
		
		while(current.isBefore(endTime)) {
			lists.add(current);
			current = current.plus(interval);
		}
		
		return lists;
	}
}
