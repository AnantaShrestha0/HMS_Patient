package com.box.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.bookstore.model.PatientModel;

public interface Patient_repo extends JpaRepository<PatientModel, Integer> {

	PatientModel findByEmailAndPassword(String email,String password);

	PatientModel findByEmail(String email);
	
	
}
