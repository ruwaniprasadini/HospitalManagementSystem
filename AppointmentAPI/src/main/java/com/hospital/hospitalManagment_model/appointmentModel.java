package com.hospital.hospitalManagment_model;


public class appointmentModel {

	private int id;
	private String name;
	private int docId;
	private String time;   
	private String date;
	//default constructor
	public appointmentModel() {
		   
	}
	//constructor with parameters
	public appointmentModel(int id, String name,int docId,String time,String date) {
		this.id = id;
		this.name = name;
		this.docId = docId;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getDocId() {
		return docId;
	}



	public void setDocId(int docId) {
		this.docId = docId;
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


