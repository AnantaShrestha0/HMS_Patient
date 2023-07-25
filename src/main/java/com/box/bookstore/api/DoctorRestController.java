package com.box.bookstore.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.model.PatientModel;

@RestController
public class DoctorRestController {

	@GetMapping("/api/doctorList")
	public List<DoctorModel> getDoctorList() {
		RestTemplate restTemplate=new RestTemplate();
		DoctorModel[] patientList=restTemplate.getForObject("http://localhost:8081/api/doctorList",DoctorModel[].class);
		List<DoctorModel> patlist=List.of(patientList);
	    return patlist;

	}
	
	
	@GetMapping("/api/doctorName")
	public String getDoctorName(int id) {
		String url="http://localhost:8081/api/doctorName/"+id;
		RestTemplate restTemplate=new RestTemplate();
		String doctorName=restTemplate.getForObject(url,String.class);
		return doctorName;
	}
}
