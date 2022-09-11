package com.John.Patientmanagementsystem;

import java.util.Date;

public class Patient {
	private int age;
	private String name;
	private Date startDate;
	private Date endDate;
	//private Medicine medicine;
	public Patient(int age, String name, Date startDate, Date endDate) {
		this.age = age;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate; 
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String toString() {
		return "Patient name is: " +name+ "\n age is: "+age+ "\n startDate on: "
	    +startDate+"\n endDate on: "+endDate;
	}
}
