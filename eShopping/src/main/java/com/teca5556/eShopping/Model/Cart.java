package com.teca5556.eShopping.Model;

public class Cart {

	private int cartid;
	private int productid;
	private int customerid;
	private String productname;
	private double productprice;
	public Cart(){
		
	}
	public Cart(int cartid, int productid, int customerid, String productname, double productprice) {
		super();
		this.cartid = cartid;
		this.productid = productid;
		this.customerid = customerid;
		this.productname = productname;
		this.productprice = productprice;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice=productprice ;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", productid=" + productid + ", customerid=" + customerid + ", productname="
				+ productname + ", productprice=" + productprice + "]";
	}
	
	
}
