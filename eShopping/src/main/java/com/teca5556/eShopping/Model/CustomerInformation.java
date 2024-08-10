package com.teca5556.eShopping.Model;

public class CustomerInformation {
	private int customerid;
	private String customername;
	private String mobilenumber;
	private String emailid;
	private String password;
	private String address;
	private String gender;
	
	public CustomerInformation() {
		}
	public CustomerInformation(int customerid, String customername, String mobilenumber, String emailid,
			String password, String address, String gender) {
		this.customerid = customerid;
		this.customername = customername;
		this.mobilenumber = mobilenumber;
		this.emailid = emailid;
		this.password = password;
		this.address = address;
		this.gender = gender;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
	
	
	

     
	
