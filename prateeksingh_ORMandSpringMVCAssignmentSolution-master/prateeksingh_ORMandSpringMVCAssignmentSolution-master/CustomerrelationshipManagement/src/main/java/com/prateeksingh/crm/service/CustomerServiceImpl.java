package com.prateeksingh.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prateeksingh.crm.dao.ICustomerDao;
import com.prateeksingh.crm.entity.Customer;

/**
 * Customer service implementation class that holds the business logic of application
 * @author prateeksingh
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDAO;
	
	/**
	 * Get all customers
	 */
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	/**
	 * Save customer details
	 */
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	/**
	 * Get customer by Id
	 */
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	/**
	 * Delete Customer by Id
	 */
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}
}
