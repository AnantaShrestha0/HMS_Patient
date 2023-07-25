package com.box.bookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.bookstore.model.AppointmentModel;

public interface Appointmentrepo extends JpaRepository<AppointmentModel, Integer>{

	
	List<AppointmentModel> findByPatientid(int id);
}
