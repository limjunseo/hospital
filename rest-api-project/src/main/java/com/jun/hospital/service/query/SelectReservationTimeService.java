package com.jun.hospital.service.query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SelectReservationTimeService {
	
	private final SelectReservationTimeServiceImpl selectReservationTimeServiceImpl;
	
	public List<LocalTime> findAvailableReservationTimes(Long doctorSsn, LocalDate date) {
		return selectReservationTimeServiceImpl.findAvailableReservationTimes(doctorSsn, date);
	}
	

}
