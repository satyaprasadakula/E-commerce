package com.teca5556.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teca5556.eShopping.Model.Cart;

public class CartDAOimpl implements CartDAO {
	//where custid=?
     private final String selectcartdata ="select * from cart ";
     private final String url1="jdbc:mysql://localhost:3306/teca5556?user=root&password=12345";
	


	public List<Cart> getAllCartDetails() {
		try {
			Connection connection=DriverManager.getConnection(url1);
			PreparedStatement ps=connection.prepareStatement(selectcartdata);
			ResultSet rs=ps.executeQuery();
			List<Cart> listofcart=new ArrayList<Cart>();
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Cart cart=new Cart();
					cart.setCartid(rs.getInt("cart_id"));
					cart.setCustomerid(rs.getInt("Product_id"));
					cart.setProductid(rs.getInt("Customer_id"));
					cart.setProductname(rs.getString("Product_name"));
					cart.setProductprice(rs.getDouble("Product_Price"));
					listofcart.add(cart);
				}
				
			}
			return listofcart;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
