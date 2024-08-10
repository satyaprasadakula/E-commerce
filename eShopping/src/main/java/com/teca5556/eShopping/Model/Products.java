package com.teca5556.eShopping.Model;

public class Products {
	private int productid;
	private String productname;
	private double productprice;
	private int quantity;
	private String brand;
	private String review;
	private String category;
	public Products(){
		}
	public Products(int productid, String productname, double productprice, int quantity, String brand, String review,
			String category) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.quantity = quantity;
		this.brand = brand;
		this.review = review;
		this.category = category;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
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
		this.productprice = productprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
				+ ", quantity=" + quantity + ", brand=" + brand + ", review=" + review + ", category=" + category + "]";
	}
	
	}


