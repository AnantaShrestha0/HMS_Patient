package com.box.bookstore.service;

import java.util.List;

import com.box.bookstore.model.AppointmentModel;

public interface AppointmentService {
   
	void addAppointment(AppointmentModel appointmentModel);
	
	List<AppointmentModel> getAllAppointment();
	
	List<AppointmentModel> getAllAppointmentByPatientId(int id);
	
	void deleteAppointment(int id);
	
	AppointmentModel getAppointmentById(int id);
	
	List<AppointmentModel> getAllAppointmentRequestByPatient(int id);
	
	List<AppointmentModel> getAllAppointmentCancelByPatient(int id);
	
	List<AppointmentModel> getAllAppointmentAcceptedByPatient(int id);
	
}
