package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Patient {
	
	 //A common method to connect to the DB
	   private Connection connect()
	   {
		 Connection con = null;
		 try
		 {
		   Class.forName("com.mysql.jdbc.Driver");

		 	//Provide the correct details: DBServer/DBName, username, password
		 	con = DriverManager.getConnection("jdbc:mysql://localhost/hospital_management", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 
		 return con;
		 
	    }
	   
	   public String insertPatient(int hospitalID, int doctorID, String appointmentID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}

				String query = " insert into patient ( `hospitalID`,`doctorID`,`appointmentID` )"
						+ " values (?, ?, ?, ?)";


				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(2, hospitalID);
				preparedStmt.setInt(3, doctorID);
				preparedStmt.setString(4, appointmentID);
				

				preparedStmt.execute();
				con.close();

				output = "Inserted successfully";
			} catch (Exception e) {
				output = "Error while inserting the item.";
				System.err.println(e.getMessage());
			}
			return output;
			
	   }
	   
		public String insertPatientDetails(String NIC, String FullName, String Gender, String MobileNo, String Address)
		 {
				String output = "";
				
				try
				{
					Connection con = connect();
					
					if (con == null)
					{return "Error while connecting to the database for inserting."; }
					
					// create a prepared statement
					String query = " insert into patientdetails(`patientNIC`,`patientName`,`patientGender`,`patientMobileNo`,`patientAddress`)"
									+ "value(?,?,?,?,?)";
					
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 		// binding values
		 
		 		preparedStmt.setString(1, NIC);
		 		preparedStmt.setString(2, FullName);
		 		preparedStmt.setString(3, Gender);
		 		preparedStmt.setString(4, MobileNo);
		 		preparedStmt.setString(5, Address);
		 		
		 
		 
		 		// execute the statement
		 			preparedStmt.execute();
		 			con.close();
		 
		 			output = "Inserted successfully";
				}
		 catch (Exception e)
		  {
			 	output = "Error while inserting the patientdetails.";
			 	System.err.println(e.getMessage());
		  }
				
			return output;
	    }
		
		public List<PatientModel> readPatient() {
			List<PatientModel> patientsList = new ArrayList<>();
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
//					return "Error while connecting to the database for reading.";
				}

				String query = "select * from patient";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String patientID = Integer.toString(rs.getInt("id"));
					String hospitalID = Integer.toString(rs.getInt("hospitalID"));
					String doctorID = Integer.toString(rs.getInt("doctorID"));
					String appointmentID = rs.getString("appointmentID");
					

					PatientModel patmodel = new PatientModel();
					patmodel.setHospitalID(hospitalID);
					patmodel.setDoctorID(doctorID);
					patmodel.setAppointmentID(appointmentID);
					patmodel.setPatientID(patientID);
					

					patientsList.add(patmodel);

					System.out.println("lol" + patientID + appointmentID);

				}

			} catch (Exception e) {

				System.err.println(e.getMessage() + "---------------------------------------------");
			}
			System.out.println(output);
			return patientsList;
		}
		
		public List<PatientModel> readPatientsUser(String id, String user) {
			String userType = "";
			List<PatientModel> patientsList = new ArrayList<>();
			switch (user) {
			case "hospital":
				userType = "hospitalID";
				break;
			case "doctor":
				userType = "doctorID";
				break;
			case "appointmentID":
				userType = "appointmentID";
				break;
				
			default:
				break;
			}

			try {
				Connection con = connect();
				if (con == null) {
//					return "Error while connecting to the database for reading.";
				}

				String query = "select * from patient where " + userType + " = " + id;

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String patientID = Integer.toString(rs.getInt("id"));
					String hospitalID = Integer.toString(rs.getInt("hospitalID"));
					String doctorID = Integer.toString(rs.getInt("doctorID"));
					String appointmentID = rs.getString("appointmentID");
					

					PatientModel patmodel = new PatientModel();
					patmodel.setHospitalID(hospitalID);
					patmodel.setDoctorID(doctorID);
					patmodel.setPatientID(patientID);
					patmodel.setAppointmentID(appointmentID);

					patientsList.add(patmodel);

				}

			} catch (Exception e) {

				System.err.println(e.getMessage());
			}
			return patientsList;
		}
		
		
		public PatientDetailsModel readPatientDetailsUser(String appointmentID){
			PatientDetailsModel details = new PatientDetailsModel();
			
				
				try
				{
					Connection con = connect();
					if (con == null){
						
						//return "Error while connecting to the database for reading."; 
						
					}
					
								
					String query = "select * from patientDetails where appointmentID = " + appointmentID;
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					// iterate through the rows in the result set
					while (rs.next())
					{
						int pId = rs.getInt("pId");
						String patientNIC = rs.getString("patientNIC");
						String patientName = rs.getString("patientName");
						String patientGender = rs.getString("patientGender");
						String patientMobileNo = rs.getString("patientMobileNo");
						String patientAddress = rs.getString("patientAddress");
						
						details.setpId(pId);
						details.setpatientNIC(patientNIC);
						details.setpatientName(patientName);
						details.setpatientGender(patientGender);
						details.setpatientMobileNo(patientMobileNo);
						details.setpatientAddress(patientAddress);

					}
				}			
						
		catch (Exception e)
		{
			System.err.println(e.getMessage() + "---------------------------------------------");
		}

		return details;
	  } 
		
	  public String updatePatientDetails(String ID, String NIC, String Fullname, String Gender, String MobileNo, String Address)
	  {
		  		String output = "";
		  		
		  		try
		  		{
		  			Connection con = connect();
		  			
		  			if (con == null)
		  			{return "Error while connecting to the database for updating."; }
		  			
		  			// create a prepared statement
		  			String query = "UPDATE patientdetails SET"
		  					+ "patientNIC=?,patientName=?,patientGender=?,patientMobileNo=?,patientAddress=? WHERE pId=?";
		        
		            PreparedStatement preparedStmt = con.prepareStatement(query);
		  			
		  			// binding values
		  			preparedStmt.setString(1, NIC);
			 		preparedStmt.setString(2, Fullname);
			 		preparedStmt.setString(3, Gender);
			 		preparedStmt.setString(4,MobileNo);
			 		preparedStmt.setString(5, Address);
		  			preparedStmt.setInt(6, Integer.parseInt(ID));
		  			
		  			// execute the statement
		  			preparedStmt.execute();
		  			con.close();
		  			
		  			output = "Updated successfully";
		  		}
		  		catch (Exception e)
		  		{
		  			output = "Error while updating the Patient.";
		  			System.err.println(e.getMessage());
		  		}
		  		
		  		return output;
		 }
	 
	  
		public String deletePatient(String pId)
		 {
				String output = "";
				
				try
				{
					Connection con = connect();
					
					if (con == null)
				    {return "Error while connecting to the database for deleting."; }
					
					// create a prepared statement
					String query = "delete from patientdetails where pId=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(pId));
					
					// execute the statement
					preparedStmt.execute();
					con.close();
					
					output = "Deleted successfully";
		        }
				catch (Exception e)
				{
					output = "Error while deleting the patientdetails.";
					System.err.println(e.getMessage());
				}
				
				return output;
		 }

}
