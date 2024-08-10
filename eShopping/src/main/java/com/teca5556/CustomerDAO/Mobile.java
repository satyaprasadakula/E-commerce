package com.teca5556.CustomerDAO;

public class Mobile {
	public static CustomerDAO internet()
	{
		CustomerDAO customerdao=new CustomerDAOimpl();
		return customerdao;
		
	}
	public static AdminDAO admin() {
		AdminDAO  admindao=new AdminDAOimpl();
		return admindao;
	}

}
