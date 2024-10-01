package com.jun.hospital.constant;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum ReservationPossibleHours {
	REGULAR_HOURS(LocalTime.of(9, 0), LocalTime.of(17, 0)),
	WEEKEND_HOURS(LocalTime.of(10, 0),LocalTime.of(14, 0));
	
	private final LocalTime startTime;
	
	private final LocalTime endTime;
	
	public boolean isPossibleReservationTime(LocalTime time) {
		return time.isAfter(this.startTime) && time.isBefore(this.endTime);
	}

}
