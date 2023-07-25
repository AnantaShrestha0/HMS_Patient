package com.box.bookstore.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.bookstore.model.PatientModel;
import com.box.bookstore.repo.Patient_repo;
import com.box.bookstore.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private Patient_repo patient_repo;
	
	@Override
	public void addpatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		patient_repo.save(patientModel);
		
		
	}

	@Override
	public PatientModel findpatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		String email=patientModel.getEmail();
		String password=patientModel.getPassword();
		
		return patient_repo.findByEmailAndPassword(email, password);
	}

	@Override
	public PatientModel findsameemail(PatientModel patientModel) {
		// TODO Auto-generated method stub
		String email=patientModel.getEmail();
		
		
		return patient_repo.findByEmail(email);
	}

	@Override
	public PatientModel getPatientId(int id) {
		// TODO Auto-generated method stub
		return patient_repo.findById(id).get();
		
	}

	@Override
	public List<PatientModel> getAllPatients() {
		// TODO Auto-generated method stub
		return patient_repo.findAll();
	}

	@Override
	public void getdeletedbyid(int id) {
		// TODO Auto-generated method stub
		patient_repo.deleteById(id);
		
	}

}
