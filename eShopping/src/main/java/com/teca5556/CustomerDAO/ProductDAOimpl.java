package com.teca5556.CustomerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teca5556.eShopping.Model.Products;

public class ProductDAOimpl implements ProductDAO{
	private final String selectProductDetails="select * from products";
	private final String url="jdbc:mysql://localhost:3306/teca5556?user=root&password=12345";
	

	public List<Products> getAllProductDetails() {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(selectProductDetails);
			ResultSet resultset=ps.executeQuery();
			List<Products> listOfProducts=new ArrayList<Products>();
			if(resultset.isBeforeFirst())
			{
				while(resultset.next())
				{
					Products products=new Products();
					products.setProductid(resultset.getInt("Product_Id"));
					products.setProductname(resultset.getString("Product_Name"));
					products.setProductprice(resultset.getDouble("Product_Price"));
					products.setCategory(resultset.getString("Product_Category"));
					products.setQuantity(resultset.getInt("Product_Quantity"));
					products.setBrand(resultset.getString("Product_Brand"));
					products.setReview(resultset.getString("Product_Review"));
					
					listOfProducts.add(products);
					
					}
			}
				return listOfProducts;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
		
	}

}
