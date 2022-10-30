package com.John.Patientmanagementsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArrayController {
	private ArrayList<Patient> array = new ArrayList<Patient>();
	@GetMapping("/index")
	public String welcome () {
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
			return "Invalid value for age";
		}
		if(ageNumber <= 0) {
			return "Invalid value for age";
		}
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		sdfrmt.setLenient(false);
		try {
		     date1 = sdfrmt.parse(sd);
		}
		catch(Exception e) {
			return "Invalid date format";
		}
		try {
		     date2 = sdfrmt.parse(ed);
		}
		catch(Exception e) {
			return "Invalid date format";
		}
		Patient p = new Patient(ageNumber,name,date1,date2);
		array.add(p);
		return "added patient: "+p.toString();
	}
	@GetMapping("/eraseArray")
	public String eraser() {
		array.clear();
		return "Array has been cleared"+ array;
	}
}
