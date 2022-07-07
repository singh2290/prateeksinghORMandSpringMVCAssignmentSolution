package com.prateeksingh.crm.dao;

import java.util.List;

import com.prateeksingh.crm.entity.Customer;

public interface ICustomerDao {

	 List<Customer> getCustomers();

	 void saveCustomer(Customer theCustomer);

	 Customer getCustomer(int theId);

	 void deleteCustomer(int theId);
}
