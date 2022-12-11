package com.John.Patientmanagementsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArrayController {
	private ArrayList<Patient> array = new ArrayList<Patient>();
	@GetMapping("/index")
	public String welcome (Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient",patient);
		model.addAttribute("PatientTable", this.array);
        return "Homepage";
	}
	@GetMapping("/addPatient")
	public String addPatient(@RequestParam(name = "age", required = true,
	defaultValue = "0")String n, @RequestParam(name = "name", required = true)  
	String name,@RequestParam(name = "StartDate", required = true)String sd,
	@RequestParam(name = "EndDate", required = true )String ed) {
		//check for valid age
		int ageNumber;
		 Date date1;
		 Date date2;
		try {
			ageNumber = Integer.parseInt(n);
		}
		catch (Exception e) {
			return "InvalidInputAge";
		}
		if(ageNumber <= 0) {
			return "InvalidInputAge";
		}
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		sdfrmt.setLenient(false);
		try {
		     date1 = sdfrmt.parse(sd);
		}
		catch(Exception e) {
			return "InvalidInputDate";
		}
		try {
		     date2 = sdfrmt.parse(ed);
		}
		catch(Exception e) {
			return "InvalidInputDate";
		}
		Patient p = new Patient(ageNumber,name,date1,date2);
		array.add(p);
		return "addPatientSuccess";
	}
	@GetMapping("/eraseArray")
	public String eraser() {
		array.clear();
		return "Array has been cleared"+ array;
	}
}
