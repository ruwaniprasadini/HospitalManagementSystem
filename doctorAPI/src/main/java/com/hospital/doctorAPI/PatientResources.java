package com.hospital.doctorAPI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hospital.doctorAPI_control.patientControl;
import com.hospital.doctorAPI_model.patientModel;



@Path("patient")
public class PatientResources {

	
	patientControl patientservice = new patientControl();
	
	//get all patient   
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<patientModel> getPatient() {   
		return patientservice.getAllpatient();
	}
	
	//get specific patient
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public patientModel search(@PathParam("id")int id){
		return patientservice.getpatient(id);
		
	}
	
	
	//create the patient
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public patientModel addPatient(patientModel p1) {
		System.out.println(p1);
		 patientservice.create(p1);
		 return p1;
		
	}
	
	 
	
	//update the patient
	@PUT
	@Path("update")   
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public patientModel updatepatient(patientModel p1) {
		System.out.println(p1);
		if(patientservice.getpatient(p1.getId()).getId()==0) {
			//id is not existing,new patient is create
			patientservice.create(p1);
			
		}
		else
		{
			//id is existing,it will update
			patientservice.update(p1);
			
		}
		
		return p1;
	}
	
	
	//delete the patient
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public patientModel deletepatient(@PathParam("id") int id) {
		patientModel p = patientservice.getpatient(id);
		
		if(p.getId()!=0);
			patientservice.delete(id);
		return null;
	
	}
	
	
}
