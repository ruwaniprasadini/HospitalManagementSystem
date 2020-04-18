package com.ZTestNew.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.ZTestNew.model.Payment;
import com.ZTestNew.model.PaymentDetailsModel;
import com.ZTestNew.model.PaymentModel;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payments")
public class PaymentService {
	
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentModel> readPayemnts() {
		return itemObj.readPayments();
	}
	
	@GET
	@Path("/{user}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentModel> readPaymentsUser(@PathParam("id") String id, @PathParam("user") String user) {
		return itemObj.readPaymentsUser(id, user);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(String paymentData) {

		JsonObject itemObject = new JsonParser().parse(paymentData).getAsJsonObject();

		int doctorID = itemObject.get("doctorID").getAsInt();
		int hospitalID = itemObject.get("hospitalID").getAsInt();
		int patientID = itemObject.get("patientID").getAsInt();
		String total = itemObject.get("total").getAsString();

		String output = itemObj.insertPayment(doctorID, hospitalID, patientID, total);
		return output;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deletePayment(@PathParam("id") String id) {

		String output = itemObj.deleteItem(id);
		return output;
	}
}
