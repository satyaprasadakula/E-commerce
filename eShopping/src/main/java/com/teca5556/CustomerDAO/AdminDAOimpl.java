package com.teca5556.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOimpl implements AdminDAO{
	
	private final String url="jdbc:mysql://localhost:3306/teca5556?user=root&password=12345";
	//private final String customerdatainsert="insert into admin (name,emailid,password)values(?,?,?)";
	

	public void adminLogin(String emailid, String password) {
	   try {
		Connection connection =DriverManager.getConnection(url);
		PreparedStatement ps=connection.prepareStatement("select * from admin where AdminMailId =? and AdminPassword=?");
	     ps.setString(1, emailid);
	     ps.setString(2, password);
	     ResultSet resultset=ps.executeQuery();
	    
	     if(resultset.next())
	     {
	    	 System.out.println("Login Successfully....");
	     }
	     else
	     {
	    	 System.out.println("Invalid Credentials.... please enter valid data...");
	     }
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	

}
