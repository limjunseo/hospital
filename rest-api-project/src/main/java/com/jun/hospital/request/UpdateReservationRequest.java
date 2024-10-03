package com.jun.hospital.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor 
@AllArgsConstructor
public class UpdateReservationRequest {
	
	private LocalDateTime newReservationTime;

}
