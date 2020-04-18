package com.hospital.hospitalManagment;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hospital.hospitalManagment_control.appointmentControl;
import com.hospital.hospitalManagment_model.appointmentModel;



@Path("appointment")
public class AppointmentResources {

	
	appointmentControl apointmentservice = new appointmentControl();
	
	//get all appointment   
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<appointmentModel> getAppointment() {   
		return apointmentservice.getAllappointment();
	}
	
	//get specific appointment
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public appointmentModel search(@PathParam("id")int id){
		return apointmentservice.getappointment(id);
		
	}
	
	
	//create the appointment
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public appointmentModel addAppointment(appointmentModel a1) {
		System.out.println(a1);
		 apointmentservice.create(a1);
		 return a1;
		
	}
	
	//update the appointment
	@PUT
	@Path("update")   
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public appointmentModel updateappointment(appointmentModel a1) {
		System.out.println(a1);
		if(apointmentservice.getappointment(a1.getId()).getId()==0) {
			//id is not existing,new appointment is create
			apointmentservice.create(a1);
			
		}
		else
		{
			//id is existing,it will update
			apointmentservice.update(a1);
			
		}
		
		return a1;
	}
	
	
	//delete the appointment
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public appointmentModel deleteappointment(@PathParam("id") int id) {
		appointmentModel a = apointmentservice.getappointment(id);
		
		if(a.getId()!=0);
			apointmentservice.delete(id);
		return null;
	
	}
	
	
}
