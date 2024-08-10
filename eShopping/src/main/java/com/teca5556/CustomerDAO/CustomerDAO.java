package com.teca5556.CustomerDAO;

import com.teca5556.eShopping.Model.CustomerInformation;

public interface CustomerDAO {
	void customerRegistration(CustomerInformation customerInformation);
	CustomerInformation customerLogin(String emailid,String password);

}
