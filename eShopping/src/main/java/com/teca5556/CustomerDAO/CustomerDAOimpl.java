package com.teca5556.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teca5556.eShopping.Model.CustomerInformation;

public class CustomerDAOimpl implements CustomerDAO{
        private final String url="jdbc:mysql://localhost:3306/teca5556?user=root&password=12345";
        private final String customerdatainsert="insert into Customer_info(Customer_Name,Customer_Mobile_Number,Customer_Email_Id,Customer_Password,Customer_Address,Customer_Gender)values(?,?,?,?,?,?)";
        
        public void customerRegistration(CustomerInformation customerinformation) {
		try {
			Connection connection =DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(customerdatainsert);
			ps.setString(1, customerinformation.getCustomername());
			ps.setString(2, customerinformation.getMobilenumber());
			ps.setString(3,customerinformation.getEmailid());
			ps.setString(4, customerinformation.getPassword());
			ps.setString(5, customerinformation.getAddress());
			ps.setString(6, customerinformation.getGender());
			int result=ps.executeUpdate();
			System.out.println(result);
			if(result != 0)
			{
				System.out.println("Customer Registration Successfull....!!!");
				
			}
			else
			{
				System.out.println("Invalid details");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
	}
	public CustomerInformation customerLogin(String emailid, String password) {
	  
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement("select * from customer_info where ( Customer_Email_Id=? or Customer_Mobile_Number=?)and Customer_Password=?");
			ps.setString(1,emailid);
			ps.setString(2, emailid);
			ps.setString(3, password);
			ResultSet result=ps.executeQuery();
			if(result.next())
			{                     
				CustomerInformation customerinformation=new CustomerInformation();
				customerinformation.setCustomerid(result.getInt("Customer_Id"));
				customerinformation.setCustomername(result.getString("Customer_Name"));
				customerinformation.setEmailid(result.getString("Customer_Email_Id"));
				customerinformation.setPassword(result.getString("Customer_Password"));
				customerinformation.setMobilenumber(result.getString("Customer_Mobile_Number"));
				customerinformation.setAddress(result.getString("Customer_Address"));
				customerinformation.setGender(result.getString("Customer_Gender"));
				
				return customerinformation;
			}
			else
			{
		        return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
