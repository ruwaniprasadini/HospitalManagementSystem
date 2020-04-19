package model;

public class PatientDetailsModel {
	
	
	private int pId;
	private String appointmentID;
	private String patientNIC;
	private String patientName;
	private String patientGender;
	private String patientMobileNo;
	private String patientAddress;
	
	public PatientDetailsModel() {
		
	}
	
	public int getpId() {
		return pId;
	}
	
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public String getappointmentID() {
		return appointmentID;
	}
	
	public void setappointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	public String patientNIC() {
		return patientNIC;
	}
	
	public void setpatientNIC(String patientNIC) {
		this.patientNIC = patientNIC;
	}
	
	public String patientName() {
		return patientName;
	}
	
	public void setpatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String patientGender() {
		return patientGender;
	}
	
	public void setpatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	
	public String patientMobileNo() {
		return patientMobileNo;
	}
	
	public void setpatientMobileNo(String patientMobileNo) {
		this.patientMobileNo = patientMobileNo;
	}
	
	public String patientAddress() {
		return patientAddress;
	}
	
	public void setpatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	

}
