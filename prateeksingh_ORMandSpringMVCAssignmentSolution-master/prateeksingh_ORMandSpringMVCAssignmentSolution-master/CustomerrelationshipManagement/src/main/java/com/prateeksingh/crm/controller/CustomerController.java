package com.prateeksingh.crm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prateeksingh.crm.entity.Customer;
import com.prateeksingh.crm.service.ICustomerService;

/**
 * Controller class for Customer
 * @author prateeksingh
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	/**
	 * initial loading page
	 * @param theModel
	 * @return
	 */
	@GetMapping()
	@Transactional
	public String loadHomePage(Model theModel) {
		return "redirect:/customer/list";
	}
	
	/**
	 * Get customer list
	 * @param theModel
	 * @return
	 */
	@GetMapping("/customer/list")
	@Transactional
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	/**
	 * Show form to add the customer details
	 * @param theModel
	 * @return
	 */
	@GetMapping("/customer/showForm")
	@Transactional
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	/**
	 * save customer and show the customer list page
	 * @param theCustomer
	 * @return
	 */
	@PostMapping("/customer/save")
	@Transactional
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);	
		return "redirect:/customer/list";
	}
	
	/**
	 * Update the customer details
	 * @param theId
	 * @param theModel
	 * @return
	 */
	@GetMapping("/customer/updateForm")
	@Transactional
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);	
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	/**
	 * Delete the customer
	 * @param theId
	 * @return
	 */
	@GetMapping("/customer/delete")
	@Transactional
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
