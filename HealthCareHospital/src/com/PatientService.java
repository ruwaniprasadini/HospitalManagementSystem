package com;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Patient;
import model.PatientDetailsModel;
import model.PatientModel;

@Path("/Patients")
public class PatientService {

	Patient patientObj = new Patient();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientModel> readPatient() {
		return patientObj.readPatient();
	}

	@GET
	@Path("/{user}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientModel> readPatientsUser(@PathParam("id") String id, @PathParam("user") String user) {
		return patientObj.readPatientsUser(id, user);
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(String patientData) {

		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject();

		int doctorID = patientObject.get("doctorID").getAsInt();
		int hospitalID = patientObject.get("hospitalID").getAsInt();
		String appointmentID = patientObject.get("appointmentID").getAsString();

		String output = patientObject.insertPatient(doctorID, hospitalID, appointmentID);
		return output;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deletePatient(@PathParam("id") String id) {

		String output = patientObj.deletePatient(id);
		return output;
	}

	@POST
	@Path("/patientDetails/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatientDetails(String PatientDetailsData) {

		JsonObject patientObj = new JsonParser().parse(PatientDetailsData).getAsJsonObject();

		String patientNIC = patientObj.get("patientNIC").getAsString();
		String patientName = patientObj.get("patientName").getAsString();
		String patientGender = patientObj.get("patientGender").getAsString();
		String patientMobileNo = patientObj.get("patientMobileNo").getAsString();
		String patientAddress = patientObj.get("patientAddress").getAsString();

		String output = patientObj.insertPatientDetails(patientNIC, patientName, patientGender, patientMobileNo,
				patientAddress);
		return output;
	}

	@GET
	@Path("/patientdetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PatientDetailsModel readPatientsDetailsUser(@PathParam("id") String id) {
		return patientObj.readPatientDetailsUser(id);
	}

	@PUT
	@Path("/patientdetails/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatientDetails(String patientDetailsData) {

		JsonObject patientObject = new JsonParser().parse(patientDetailsData).getAsJsonObject();

		String patientNIC = patientObject.get("patientNIC").getAsString();
		String patientName = patientObject.get("patientName").getAsString();
		String patientGender = patientObject.get("patientGender").getAsString();
		String patientMobileNo = patientObject.get("patientMobileNo").getAsString();
		String patientAddress = patientObject.get("patientAddress").getAsString();
		int pId = patientObject.get("pId").getAsInt();
		
		String output = patientObj.updatePatientDetails(patientNIC, patientName, patientGender, patientMobileNo, patientAddress,  pId);
		return output;

	}
}