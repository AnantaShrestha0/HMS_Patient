package com.box.bookstore.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.bookstore.model.AppointmentModel;
import com.box.bookstore.repo.Appointmentrepo;
import com.box.bookstore.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private Appointmentrepo appointmentrepo;

	@Override
	public void addAppointment(AppointmentModel appointmentModel) {
		// TODO Auto-generated method stub
		appointmentrepo.save(appointmentModel);
		
	}

	@Override
	public List<AppointmentModel> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentrepo.findAll();
	}

	@Override
	public List<AppointmentModel> getAllAppointmentByPatientId(int id) {
		// TODO Auto-generated method stub
		return appointmentrepo.findByPatientid(id);
	}

	@Override
	public void deleteAppointment(int id) {
		// TODO Auto-generated method stub
		
		appointmentrepo.deleteById(id);
		
	}

	@Override
	public AppointmentModel getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentrepo.findById(id).get();
	}

	@Override
	public List<AppointmentModel> getAllAppointmentRequestByPatient(int id) {
		// TODO Auto-generated method stub
		
		List<AppointmentModel> appointmentList=appointmentrepo.findByPatientid(id);
		List<AppointmentModel> appointmentRequest=new ArrayList<>();
		for (AppointmentModel appointment:appointmentList) {
			String check="pending";
			String appointmentReq=appointment.getAppointmentStatus();
			if(appointmentReq.equals(check)) {
				appointmentRequest.add(appointment);
			}
		}
		
		return appointmentRequest;
	}

	@Override
	public List<AppointmentModel> getAllAppointmentCancelByPatient(int id) {
		// TODO Auto-generated method stub
	
		List<AppointmentModel> appointmentList=appointmentrepo.findByPatientid(id);
		List<AppointmentModel> appointmentCancel=new ArrayList<>();
		for (AppointmentModel appointment:appointmentList) {
			String check="canceled";
			String appointmentCan=appointment.getAppointmentStatus();
			if(appointmentCan.equals(check)) {
				appointmentCancel.add(appointment);
			}
		}
		
		return appointmentCancel;
	}
	

	@Override
	public List<AppointmentModel> getAllAppointmentAcceptedByPatient(int id) {
		// TODO Auto-generated method stub
	

		List<AppointmentModel> appointmentList=appointmentrepo.findByPatientid(id);
		List<AppointmentModel> appointmentAccepted=new ArrayList<>();
		for (AppointmentModel appointment:appointmentList) {
			String check="accepted";
			String appointmentAccept=appointment.getAppointmentStatus();
			if(appointmentAccept.equals(check)) {
				appointmentAccepted.add(appointment);
			}
		}
		
		return appointmentAccepted;
	}

}
