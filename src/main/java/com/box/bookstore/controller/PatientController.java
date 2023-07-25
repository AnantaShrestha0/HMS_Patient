package com.box.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.bookstore.model.PatientModel;
import com.box.bookstore.service.PatientService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/login")
	public String getlogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postlogin(PatientModel patientModel,Model model,RedirectAttributes redirectAttributes,HttpSession session) {
		
		PatientModel p=patientService.findpatient(patientModel);
		if(p==null) {
			model.addAttribute("username_error","username or password not matched");
			return "login";
		}
	  
		try {
		if(p.getRegistered().equals("yes")) {
//			int n=p.getId();			
//			return "redirect:/patientinterface/"+n;
//			redirectAttributes.addFlashAttribute("patientobj",p);
			session.setAttribute("validuser",p);
			return "redirect:/patientinterface";
		}
		}catch(Exception e) {
		
		
		int id=p.getId();
		model.addAttribute("userObject", patientService.getPatientId(id));
		
		return "registration";
		}
		int id=p.getId();
		model.addAttribute("userObject", patientService.getPatientId(id));
		
		return "registration";
	}
	
	@GetMapping("/signup")
	public String getsignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postsignup(PatientModel patientModel,Model model) {
		
		String pass=patientModel.getPassword();
		String conpass=patientModel.getConpassword();
		PatientModel p=patientService.findsameemail(patientModel);
		if(p==null) {
		if(pass.equals(conpass)){
			
			patientService.addpatient(patientModel);
			return "login";
		}
		model.addAttribute("same_username_found", "Password not matched");
		return "signup";
		}
		model.addAttribute("same_username_found", "This email is already registered");
		return "signup";
		
	}
	
	@GetMapping("/logout")
	private String logOut(HttpSession session) {
		session.invalidate();//session kill
		return "login";
	}
	
	
	
	@PostMapping("/registration")
	public String postregistration(PatientModel patientModel) {
		patientModel.setRegistered("yes");
		patientService.addpatient(patientModel);
		return "redirect:/patientinterface";
		
	}
	

}
