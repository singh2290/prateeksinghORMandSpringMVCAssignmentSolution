package com.prateeksingh.crm.service;

import java.util.List;

import com.prateeksingh.crm.entity.Customer;

public interface ICustomerService {

	 List<Customer> getCustomers();

	 void saveCustomer(Customer theCustomer);

	 Customer getCustomer(int theId);

	 void deleteCustomer(int theId);
	
}
