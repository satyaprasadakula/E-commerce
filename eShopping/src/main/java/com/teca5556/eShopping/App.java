package com.teca5556.eShopping;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.teca5556.CustomerDAO.AdminDAO;
import com.teca5556.CustomerDAO.CartDAO;
import com.teca5556.CustomerDAO.CartDAOimpl;
import com.teca5556.CustomerDAO.CustomerDAO;
import com.teca5556.CustomerDAO.CustomerPurchaseDAO;
import com.teca5556.CustomerDAO.CustomerPurchaseDAOimpl;
import com.teca5556.CustomerDAO.Mobile;
import com.teca5556.CustomerDAO.ProductDAO;
import com.teca5556.CustomerDAO.ProductDAOimpl;
import com.teca5556.eShopping.Model.Cart;
import com.teca5556.eShopping.Model.CustomerInformation;
import com.teca5556.eShopping.Model.CustomerPurchase;
import com.teca5556.eShopping.Model.Products;
/**
 * Hello world!
 *
 */
public class App 
{
	static int count=1;

    public static void main( String[] args)
    {
    	
    	 
    	Scanner sc=new Scanner(System.in);
    	   CustomerDAO customerdao=Mobile.internet();
    	   CustomerInformation customerinformation=new CustomerInformation();
    	   AdminDAO admindao=Mobile.admin();
    	   ProductDAO productDAO=new ProductDAOimpl();
    	   CustomerPurchaseDAO customerpurchasedao=new CustomerPurchaseDAOimpl();
    	   CartDAO cartdao=new CartDAOimpl(); 
    	   
    	   
    	   List<Products> selectedproducts=new ArrayList<Products>();
    	   List<CustomerPurchase> customerpurchaselist=new ArrayList<CustomerPurchase>();
    	   
    	   
        System.out.println("Welcome To e-Shopping Application");
        System.out.println("****-------******--------******-----******");
        System.out.print("LOADING");
        for(int i=1;i<=5;i++)
        {
        	try {
        	System.out.print(".");
        	Thread.sleep(800);
        	}catch(InterruptedException e)
        	{
        		e.printStackTrace();
        	}
        }
        while(true)
        {
        	System.out.println("Enter \n1)For Customer Registration\n2)For Customer Login\n3)Adminlogin");
        	int option=sc.nextInt();
        	switch(option) {
        	
        	case 1:{
        		System.out.println("Enter the name ");
        		String name=sc.next();
        		System.out.println("Enter the Mobile number");
        		String number=sc.next();
        		while(true) {
        			if(number.length()==10) {
        				break;
        			}else
        			{
        				System.out.println("Enter 10 digits of mobile number");
        				number=sc.next();
        			}
        		}
        		System.out.println("Enter the Emailid");
        		String email=sc.next();
        		System.out.println("Enter your password");
        		String password=sc.next();
        		while(true){
        			if(password.length()==4) {
        				break;
        			}else {
        				System.out.println("Enter the 4 digt password");
        				password =sc.next();
        			}
        		}
        		
        		System.out.println("Enter the address");
        		String address=sc.next();
        		System.out.println("Enter your gender");
        		String gender=sc.next();
        		customerinformation.setCustomername(name);
        		customerinformation.setMobilenumber(number);
        		customerinformation.setEmailid(email);
        		customerinformation.setPassword(password);
        		customerinformation.setAddress(address);
        		customerinformation.setGender(gender);
        	    customerdao.customerRegistration(customerinformation);
        		
        	}
        	break;
        	case 2:
        	{
        		System.out.println("Enter the emailid");
        		String emailid=sc.next();
        		System.out.println("Enter the password");
        		String password=sc.next();
        		
        		 CustomerInformation customerlogindetails=customerdao.customerLogin(emailid, password);
        		 if(customerlogindetails !=null) {
        		 if(customerlogindetails.getGender().equalsIgnoreCase("Male"))
        		 {
        			 System.out.println("Hello MR :-"+customerlogindetails.getCustomername());
        		 }
        		 else
        		 {
        			System.out.println("Hello MS :-"+customerlogindetails.getCustomername()); 
        		 }
        		 System.out.println("Enter \n 1.For Product Details \n 2.For Cart Details ");
        		 int opt=sc.nextInt();
        		 
        		 switch(opt) {
        		 case 1:{
        			
        			 System.out.println("***----****-----Product Details---****---****");
        			 System.out.println("S.no ProductName");
        			 
        			 List<Products> allProductDetails=productDAO.getAllProductDetails();
        		     allProductDetails.forEach((products)->{
        		    	 System.out.println("sno"+count++);
        		    	 System.out.println("Product name"+products.getProductname());
                         System.out.println("Product price"+products.getProductprice());  
                         System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*");
        		     });
        		     boolean productpurchasestatus=true;
        		     while(productpurchasestatus)
        		     {
        		    	 System.out.println("Select S.No to purchase or To add the produc to cart");
        		    	 int sno=sc.nextInt();
        		    	 Products products=allProductDetails.get(sno-1);
        		    	 boolean quantitystatus=true;
        		    	 while(quantitystatus) {
        		    	 System.out.println("Enter the Quantity");
        		    	 int quantity=sc.nextInt();
        		    	 System.out.println(products);
        		    	 System.out.println(quantity);
        		    	 if(quantity <=products.getQuantity())
        		    	 {
        		    	 productpurchasestatus=true;
        		    	 quantitystatus=false;
        		    	 products.setQuantity(quantity);
        		    	 selectedproducts.add(products);
        		    	 System.out.println("Do you want to choose more Products \n yes\n No");
        		    	 String res=sc.next();
        		    	
        		    	 if(res.equalsIgnoreCase("yes"))
        		    	 {
        		    		 productpurchasestatus=true; 
        		    		 quantitystatus=false;
        		    	 }
        		    	 else
        		    	 {
        		    		 productpurchasestatus=false;
        		    		 quantitystatus=false;
        		    		 System.out.println("\n 1 For Purchase \n 2 For Add to Cart");
            		    	 int userchoice=sc.nextInt();
            		    	 switch(userchoice) {
            		    	 case 1:
            		    	 
            		    		 System.out.println("product was purchased");
            		    		 System.out.println(selectedproducts);
            		    		 double total=0;
            		    		
            		    		 
            		    		 for(int i=0;i<selectedproducts.size();i++)
            		    		 {
            		    			 Products products2=selectedproducts.get(i);
            		    			 
            		    			 CustomerPurchase customerpurchase=new CustomerPurchase();
            		    			 customerpurchase.setProductname(products2.getProductname());
            		    			 customerpurchase.setProductprice(products2.getProductprice());
            		    			 customerpurchase.setPurchasequantity(products2.getQuantity());
            		    			 customerpurchase.setProductid(products2.getProductid());
            		    			 customerpurchase.setPurchasedate(Date.valueOf(LocalDate.now()));
            		    			 customerpurchase.setPurchasetime(Time.valueOf(LocalTime.now()));
            		    			 customerpurchase.setCustomerid(customerlogindetails.getCustomerid());
            		    			 total=total+customerpurchase.getProductprice()*customerpurchase.getPurchasequantity();
            		    			    
            		    			 customerpurchaselist.add(customerpurchase);
            		    			 }
            		    		 System.out.println(customerpurchaselist);
            		    		
            		    		 System.out.println("Total Amount to pay :-"+total);
            		    		 
            		             boolean amountstatus=true;
            		    	     while(amountstatus) {
            		    	    	System.out.println("Enter amount to pay:");
            		    	    	double useramount=sc.nextDouble();
            		    	    	if(useramount>=0) {
            		    	    		if(useramount==total) {
            		    	    			amountstatus=false;
            		    	    			customerpurchasedao.addDataToPurchaseList(customerpurchaselist);
            		    	    		}
            		    	    		else
            		    	    		{
            		    	    			System.out.println("Amount not equals to the total amount");
            		    	    			System.out.println("your total Amount to pay:"+total);
            		    	    			amountstatus=true;
            		    	    		}
            		    	  
            		    	    	}else
            		    	    	{
            		    	    		System.out.println("Invalid Amount");
            		    	    		amountstatus=true;
            		    	    	}
            		    	     }
            		    	
            		    		 break;
            		    	 case 2:
            		    		 System.out.println("Product Added to Cart");
            		    		 break;
            		    	default:
            		    		System.out.println("Invalid Option");
            		    		break;
            		    	 }
        		    		 
        		    		 
        		    	 }
        		    	 }
        		    	 else
        		    	 {
        		    		 System.out.println("Out of Stock");
        		    		 System.out.println("Enter the quantity within the Stock:"+products.getQuantity());
        		    		 System.out.println("Choose the quantity below to the displayed Quantity");
        		    	}
        		    	 }
        		    	 
        		     }
        		 }
        		 break;
        		 case 2:{
        			 System.out.println("***-----***---- Cart Details---****----***");
        			 System.out.println("s.no Productname");
        			 
        			 List<Cart> allcartdetails;
						
						allcartdetails = cartdao.getAllCartDetails();
						
        			 allcartdetails.forEach((cart)->{
        				 System.out.println("product name: "+cart.getProductname());
        			     System.out.println("Product price:"+cart.getProductprice());
        			     
        			 });
        			 
        		 }
        		 break;
        		
        		 }
        		 }
        		 else
        		 {
        			 System.out.println("Invalid Details");
        		 }
        		 
        	}
        	break;
        	case 3:
        	{
        		System.out.println("Enter the emailid");
        		String emailid=sc.next();
        		System.out.println("Enter the password");
        		String password=sc.next();
        		admindao.adminLogin(emailid,password);
        	}
        	break;
        	}
        	System.out.println("Do you want to continue the application...");
        	System.out.println("Enter \n yes-if you want to continue \n No to exit");
        	if(sc.next().equalsIgnoreCase("yes"))
        		continue;
        	else
        		System.out.println("Thank You ");
        		break;
        }   
    }	
}
