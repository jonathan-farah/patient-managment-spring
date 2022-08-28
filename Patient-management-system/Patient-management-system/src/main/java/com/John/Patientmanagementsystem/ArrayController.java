package com.John.Patientmanagementsystem;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayController {
	private ArrayList<Integer> array = new ArrayList<Integer>();
	@GetMapping("/addnum")
	public String addNumber(@RequestParam(name = "number", required = false,
	defaultValue = "0")int n) {
		array.add(n);
		String returnVal = "";
		returnVal += "succesfully added #: " + n +"\n array is "+ array;
		return returnVal;
	}
	@GetMapping("/eraseArray")
	public String eraser() {
		array.clear();
		return "Array has been cleared"+ array;
	}
	@GetMapping("/sumation")
	public String addNum() {
		int sum = 0;
		for(int x: array) {
			sum+=x;
		}
		return "The sum of all the numbers is "+sum;
	}
}
