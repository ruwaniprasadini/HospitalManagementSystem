package com.hospital.doctorAPI_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.doctorAPI_dataBase.DataBase;
import com.hospital.doctorAPI_model.patientModel;




public class patientControl {
Connection con = DataBase.connector();
	

	
	
	//execute the select all query 
	public List<patientModel> getAllpatient(){
		 List<patientModel> patient = new ArrayList<>();
	   	 String sql = "SELECT * FROM addpatient";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  patientModel p = new patientModel();
					  p.setId(rs.getInt(1));
					  p.setAge(rs.getInt(2));
					  p.setContactNo(rs.getInt(3));
					  p.setName(rs.getString(4));
					  p.setGender(rs.getString(5));
					  p.setEmail(rs.getString(6));
					  p.setAddress(rs.getString(7));
					  p.setMedicleReport(rs.getString(8));
					  p.setTime(rs.getString(9));
					  p.setDate(rs.getString(10));
					  
					   
					  
					  patient.add(p);
				  }
				   
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return patient;
	    }
	
	
	//execute the select all in specific id
	public  patientModel getpatient(long id) {
		 
		   	 String sql = "SELECT * FROM addpatient WHERE id="+id;
		   	patientModel p = new patientModel();
		   	 try 
		   	   {
					  Statement st = con.createStatement();
					  ResultSet rs = st.executeQuery(sql);
					  if(rs.next())
					  {
						 
						  p.setId(rs.getInt(1));
						  p.setAge(rs.getInt(2));
						  p.setContactNo(rs.getInt(3));
						  p.setName(rs.getString(4));
						  p.setGender(rs.getString(5));
						  p.setEmail(rs.getString(6));
						  p.setAddress(rs.getString(7));
						  p.setMedicleReport(rs.getString(8));
						  p.setTime(rs.getString(9));
						  p.setDate(rs.getString(10));
						  
						     
					  }
	}
		   	 catch (Exception e) 
		   	  {
					
				   System.out.println(e);
		   	  }
		   	 return p;
		    }
	
	
	//execute the insert query

	public void create(patientModel p1) 
	{
		String sql = "INSERT INTO addpatient values(?,?,?,?,?,?,?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, p1.getId());
		  st.setInt(2, p1.getAge());
		  st.setInt(3, p1.getContactNo());
		  st.setString(4, p1.getName());
		  st.setString(5, p1.getGender());
		  st.setString(6, p1.getEmail());
		  st.setString(7, p1.getAddress());
		  st.setString(8, p1.getMedicleReport());
		  st.setString(9, p1.getTime());
		  st.setString(10, p1.getDate());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
	//execute the update query
	public void update(patientModel p1) 
	{
		
		String sql = " UPDATE addpatient SET age=?,contactNo=?,name=?,gender=?,email=?,address=?,medicleReport=?,time=?,date=? WHERE id=?";
		
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

		  
		  st.setInt(1, p1.getAge());
		  st.setInt(2, p1.getContactNo());
		  st.setString(3, p1.getName());
		  st.setString(4, p1.getGender());
		  st.setString(5, p1.getEmail());
		  st.setString(6, p1.getAddress());
		  st.setString(7, p1.getMedicleReport());
		  st.setString(8, p1.getTime());
		  st.setString(9, p1.getDate());
		  st.setInt(10, p1.getId());
		  
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	//execute the delete query

	public void delete(int id) {

		String sql = "DELETE FROM addpatient WHERE id=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, id);
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 

	}
   	 

}
