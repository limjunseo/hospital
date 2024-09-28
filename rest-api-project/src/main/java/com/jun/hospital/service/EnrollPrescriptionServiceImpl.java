package com.jun.hospital.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.hospital.entity.Doctor;
import com.jun.hospital.entity.Drug;
import com.jun.hospital.entity.Patient;
import com.jun.hospital.entity.Prescription;
import com.jun.hospital.repository.PrescriptionRepository;
import com.jun.hospital.response.PrescriptionResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnrollPrescriptionServiceImpl {
	
	@Autowired
	private final DoctorService doctorService;
	
	@Autowired
	private final PatientService patientService;
	
	@Autowired
	private final DrugService drugService;
	
	@Autowired
	private final PrescriptionRepository prescriptionRepository;
	
	public Prescription enrollPrescription(Prescription prescription) {
		Prescription.Id pk = prescription.getId(); //Prescription의 pk(doctorSSN, patientSSN, companyName, tradeName)		
		
		Doctor doctor = doctorService.findById(pk.getDoctorSSN());
		Patient patient = patientService.findById(pk.getPatientSSN());
		
		String companyName = pk.getCompanyName();
		String tradeName = pk.getTradeName();
		Drug.Id drugId = Drug.Id.create(tradeName, companyName);
		
		Drug drug = drugService.findById(drugId);
		
		prescription.prescribe(doctor, patient, drug); //비즈니스 Impl 계층에서 객체참조 설정하기
		
		return prescriptionRepository.save(prescription);
		
	}

	public Prescription updatePrescription(Prescription existingPrescription, int quantity) {
		existingPrescription.updatePrescription(LocalDate.now(), quantity);
		return existingPrescription;
	}
	

	

}





//private Long DoctorSSN;
//private Long paitentSSN;
//private String companyName;
//private String tradeName;
//private LocalDate date;
//private int quantity;
//}