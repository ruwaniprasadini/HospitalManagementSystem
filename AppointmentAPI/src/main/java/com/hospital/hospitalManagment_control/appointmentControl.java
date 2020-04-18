package com.hospital.hospitalManagment_control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.hospitalManagment_dataBase.DataBase;
import com.hospital.hospitalManagment_model.appointmentModel;




public class appointmentControl {
Connection con = DataBase.connector();
	

	
	
	//execute the select all query 
	public List<appointmentModel> getAllappointment(){
		 List<appointmentModel> appointment = new ArrayList<>();
	   	 String sql = "select * from appointments";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  appointmentModel a = new appointmentModel();
					  a.setId(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setDocId(rs.getInt(3));
					  a.setTime(rs.getString(4));
					  a.setDate(rs.getString(5));
					  
					   
					  
					  appointment.add(a);
				  }
				   
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return appointment;
	    }
	
	
	//execute the select all in specific id
	public  appointmentModel getappointment(long id) {
		 
		   	 String sql = "select * from appointments where id="+id;
		   	appointmentModel a = new appointmentModel();
		   	 try 
		   	   {
					  Statement st = con.createStatement();
					  ResultSet rs = st.executeQuery(sql);
					  if(rs.next())
					  {
						 
						  a.setId(rs.getInt(1));
						  a.setName(rs.getString(2));
						  a.setDocId(rs.getInt(3));
						  a.setTime(rs.getString(4));
						  a.setDate(rs.getString(5));
						  
						     
					  }
	}
		   	 catch (Exception e) 
		   	  {
					
				   System.out.println(e);
		   	  }
		   	 return a;
		    }
	
	
	//execute the insert query

	public void create(appointmentModel a1) 
	{
		String sql = "insert into appointments values(?,?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, a1.getId());
		  st.setString(2, a1.getName());
		  st.setInt(3, a1.getDocId());
		  st.setString(4, a1.getTime());
		  st.setString(5, a1.getDate());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
	//execute the update query
	public void update(appointmentModel a1) 
	{
		String sql = "update appointments set name=?,docid=?,time=?,date=? where id=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

		  st.setString(1, a1.getName());
		  st.setInt(2, a1.getDocId());
		  st.setString(3, a1.getTime());
		  st.setString(4, a1.getDate());
		  st.setInt(5, a1.getId());
		  
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	//execute the delete query

	public void delete(int id) {

		String sql = "delete from appointments where id=?";
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
