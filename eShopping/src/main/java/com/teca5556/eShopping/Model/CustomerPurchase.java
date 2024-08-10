package com.teca5556.eShopping.Model;

import java.sql.Date;
import java.sql.Time;

public class CustomerPurchase {
	private int purchase_id;
	private String productname;
	private double  productprice;
	private int purchasequantity;
    private  Date purchasedate;
    private Time purchasetime;
    private int customerid;
    private int productid;
    public CustomerPurchase() {
    	
    }
    
    public CustomerPurchase(int purchase_id, String productname, double productprice, int purchasequantity,
			Date purchasedate, Time purchasetime, int customerid,int productid) {
		super();
		this.purchase_id = purchase_id;
		this.productname = productname;
		this.productprice = productprice;
		this.purchasequantity = purchasequantity;
		this.purchasedate = purchasedate;
		this.purchasetime = purchasetime;
		this.customerid = customerid;
		this.productid=productid;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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

	public int getPurchasequantity() {
		return purchasequantity;
	}

	public void setPurchasequantity(int purchasequantity) {
		this.purchasequantity = purchasequantity;
	}

	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public Time getPurchasetime() {
		return purchasetime;
	}

	public void setPurchasetime(Time purchasetime) {
		this.purchasetime = purchasetime;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "CustomerPurchase [purchase_id=" + purchase_id + ", productname=" + productname + ", productprice="
				+ productprice + ", purchasequantity=" + purchasequantity + ", purchasedate=" + purchasedate
				+ ", purchasetime=" + purchasetime + ", customerid=" + customerid + ", productid=" + productid + "]";
	}
	

    
}
