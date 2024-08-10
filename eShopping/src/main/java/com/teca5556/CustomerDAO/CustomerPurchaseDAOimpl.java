package com.teca5556.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.teca5556.eShopping.Model.CustomerPurchase;

public class CustomerPurchaseDAOimpl implements  CustomerPurchaseDAO{

	

	private final String url="jdbc:mysql://localhost:3306/teca5556?user=root&password=12345";
	private final String insertcustomerpurchase= "insert into purchase_list(Product_Name,Product_Price,Purchase_Quantity,Purchase_Date,Purchase_Time,Customer_Id,Product_id) value(?,?,?,?,?,?,?)";
	
	
	public void addDataToPurchaseList(List<CustomerPurchase> customerpurchases) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(insertcustomerpurchase);
			
			customerpurchases.forEach((customerpurchased)->{
			try {
				ps.setString(1,customerpurchased.getProductname());
				ps.setDouble(2,customerpurchased.getProductprice() );
				ps.setInt(3, customerpurchased.getPurchasequantity());
				ps.setDate(4,customerpurchased.getPurchasedate());
				ps.setTime(5,customerpurchased.getPurchasetime());
				ps.setInt(6, customerpurchased.getCustomerid());
				ps.setInt(7, customerpurchased.getProductid());
				ps.addBatch();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			});
			int[] result=ps.executeBatch();
			if(result.length!=0) {
				System.out.println("Data Added Successfully");
			}
			else
			{
				System.out.println("Server 404");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
