package com.box.bookstore.service;

import java.util.List;

import com.box.bookstore.model.PatientModel;

public interface PatientService {
	
	void addpatient(PatientModel patientModel);
	PatientModel findpatient(PatientModel patientModel);
	PatientModel findsameemail(PatientModel patientModel);
	PatientModel getPatientId(int id);
	List<PatientModel> getAllPatients();
	void getdeletedbyid(int id);
	

}
