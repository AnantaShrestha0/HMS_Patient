package com.box.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AppointmentModel {
	
	@Id
	@GeneratedValue
	private int id;
	private int patientid;
	private String patient_name;
	private String doctor_id;
	private String doctor_name;
	private String email;
	private String phonenumber;
	private String symptoms;
	private String appointmentdate;
	private String appointmentStatus;
	
	

}
