package com.John.Patientmanagementsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArrayController {
	private ArrayList<Patient> array = new ArrayList<Patient>();
	@GetMapping("/index")
	public String welcome (Model model) {
		//create new patient object for model
		Patient patient = new Patient();
		//add the new patient object to model
		model.addAttribute("patient",patient);
		//add the patient array to model for the patient display table
		model.addAttribute("PatientTable", this.array);
        return "Homepage";
	}
	
	@PostMapping("/index")
	public String submitForm(@ModelAttribute("patient") Patient patient) {
	    array.add(patient);
	    return "addPatientSuccess";
	}
	@GetMapping("/eraseArray")
	public String eraser() {
		array.clear();
		return "Array has been cleared"+ array;
	}
}
