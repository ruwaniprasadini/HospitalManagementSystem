package com.hospital.doctorAPI_dataBase;
import java.sql.Connection;
import java.sql.DriverManager;


public class DataBase {
	
	public static Connection connector()
	{
		Connection con = null;
		
		
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection Top");
			//con =  (Connection) DriverManager.getConnection(url,username,password);
			con = DriverManager.getConnection("jdbc:mysql://localhost/hospital_management?user="+username+"&password="+password);
			System.out.println("Connection Done");
			if (con != null) {
                System.out.println("Connected to the fail");
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}