package com.box.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.bookstore.api.DoctorRestController;
import com.box.bookstore.model.AppointmentModel;
import com.box.bookstore.model.PatientModel;
import com.box.bookstore.service.AppointmentService;
import com.box.bookstore.service.PatientService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppointmentController {

	
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorRestController doctorRestController;
	
	@PostMapping("/appointment")
	public String postAppointment(AppointmentModel appointmentModel,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		
		PatientModel p=(PatientModel) httpSession.getAttribute("validuser");
		int id=p.getId();
		appointmentModel.setPatientid(id);
		String sid=appointmentModel.getDoctorId();
		int iid=Integer.parseInt(sid);
		appointmentModel.setDoctor_name(doctorRestController.getDoctorName(iid));
		appointmentModel.setAppointmentStatus("pending");
		appointmentModel.setPatientCancel("nothing");
		appointmentService.addAppointment(appointmentModel);
		return "redirect:/patientinterface";
	}
	

	
	@GetMapping("/appointmentCancel")
	public String getAppointmentcancel(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
	
		
		appointmentService.deleteAppointment(id);
	
		return "redirect:/appointmentCancelList";
		
	}
	@GetMapping("/appointmentPatientCanceled")
	public String getAppointmentPatientcanceled(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
	
		
		appointmentService.patientCancelFunction(id);
	
		return "redirect:/appointmentAcceptedList";
		
	}
}
