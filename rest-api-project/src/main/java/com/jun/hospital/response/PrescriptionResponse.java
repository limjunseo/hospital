package com.jun.hospital.response;

import java.time.LocalDate;

import com.jun.hospital.entity.Prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionResponse {
	
	private Long doctorSSN;
	private Long patientSSN;
	private String company;
	private String tradeName;
	private LocalDate date;

	public static PrescriptionResponse of(Prescription prescription) {
		Prescription.Id id = prescription.getId();
		PrescriptionResponse prescriptionResponse = new PrescriptionResponse();
		
		prescriptionResponse.doctorSSN = id.getDoctorSSN();
		prescriptionResponse.patientSSN = id.getPatientSSN();
		prescriptionResponse.tradeName = id.getTradeName();
		prescriptionResponse.company = id.getCompanyName();
		prescriptionResponse.date = prescription.getPrescribeDate();
		
		return prescriptionResponse;
	}
}


//아래와 같은 일반적인 response 객체를 생성하는것도 고려

//public class ApiResponse<T> {
//    private List<T> data;
//    private int totalItems;
//    private String message;
//
//    // Getters, Setters, Constructor
//}


//public class PaginatedResponse<T> {
//    private List<T> data;
//    private long totalItems;
//    private int currentPage;
//    private int pageSize;
//    private int totalPages;
//}