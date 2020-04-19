package model;

public class PatientModel {
	
	private String patientID;
	private String hospitalID;
	private String doctorID;
	private String appointmentID;
	
	
	public PatientModel() {
		
	}
	
	public PatientModel(String patientID,  String hospitalID, String doctorID,
			String appointmentID 
			) {
		super();
		
		this.patientID = patientID;
		this.hospitalID = hospitalID;
		this.doctorID = doctorID;
		this.appointmentID = appointmentID;
		
	}
	
	
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String pId) {
		this.patientID = patientID;
	}

	public String getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	

	
	

}
