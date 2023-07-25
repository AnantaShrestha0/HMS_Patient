package com.box.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.bookstore.api.DoctorRestController;
import com.box.bookstore.model.AppointmentModel;
import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.model.PatientModel;
import com.box.bookstore.repo.Patient_repo;
import com.box.bookstore.service.AppointmentService;
import com.box.bookstore.service.PatientService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class PatientPageController {
	
	@Autowired 
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorRestController doctorRestController;

	

	
	@GetMapping("/patientinterface")
	public String getPatienInterface(Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		List<DoctorModel> doctorList=doctorRestController.getDoctorList();
		
	//	PatientModel p=(PatientModel) httpSession.getAttribute("validuser");
		model.addAttribute("appointmentindicator","active");
		model.addAttribute("doctorList",doctorList);
		model.addAttribute("appointmentList",appointmentService.getAllAppointment());
		return "patientuserinterface";
		
	}
	
	@GetMapping("/upload")
	public String getPatienIne(PatientModel patientModel,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		
		return "upload";
		
	}
	

	
	
	@GetMapping("/appointmentlist")
	public String getAppointmentList(Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		
		PatientModel p=(PatientModel) httpSession.getAttribute("validuser");

		List<AppointmentModel> appointment=appointmentService.getAllAppointmentRequestByPatient(p.getId());
		model.addAttribute("appointmentlistindicator","active");
		model.addAttribute("appointmentList",appointment );
	//	model.addAttribute("patient",appointment);
		
		return "appointmentlist";
		
	}
	
	@GetMapping("/appointmentRequestList")
	public String getAppointmentRequestList(Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		
		PatientModel p=(PatientModel) httpSession.getAttribute("validuser");

		List<AppointmentModel> appointment=appointmentService.getAllAppointmentRequestByPatient(p.getId());
		model.addAttribute("appointmentRequestListIndicator","active");
		model.addAttribute("appointmentList",appointment );
	//	model.addAttribute("patient",appointment);
		
		return "appointmentlist";
		
	}
	

	@GetMapping("/appointmentAcceptedList")
	public String getAppointmentAcceptedList(Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validuser")==null) {
			return "login";
		}
		
		PatientModel p=(PatientModel) httpSession.getAttribute("validuser");

		List<AppointmentModel> appointment=appointmentService.getAllAppointmentAcceptedByPatient(p.getId());
		model.addAttribute("appointmentAcceptedListIndicator","active");
		model.addAttribute("appointmentList",appointment );
	//	model.addAttribute("patient",appointment);
		
		return "appointmentlist";
		
	}
	
	
	

	


}
