package com.hospital.doctorAPI_model;


public class patientModel {

	private int id;
	private int age;
	private int contactNo;
	private String name;
	private String gender;
	private String email;
	private String address;
	private String medicleReport;
	private String time;   
	private String date;
	
	//default constructor
	public patientModel() {
		   
	}
	//constructor with parameters
	public patientModel(int id, int age, int contactNo, String name, String gender, String email, String address, String medicleReport,
			String time, String date) {
		
		this.id = id;
		this.age = age;
		this.contactNo = contactNo;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.medicleReport = medicleReport;
		this.time = time;
		this.date = date;
	}
	
	
	//getters and setters to fetching data
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMedicleReport() {
		return medicleReport;
	}
	
	public void setMedicleReport(String medicleReport) {
		this.medicleReport = medicleReport;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	



	
	
		

}


