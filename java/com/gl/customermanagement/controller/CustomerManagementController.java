package com.gl.customermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import com.gl.customermanagement.entityclass.Customer;
import com.gl.customermanagement.service.CustomerService;

// contoller class which will be called by dispacher servelet
@Controller
public class CustomerManagementController {
	
	//dependency injection with customer service for CURD operation
	@Autowired
	public CustomerService customerService;
	
	//initial page to main page to redirect to list page.
	@RequestMapping("/")
	public String MainPage() {
		return "mainpage";
	}
	
	// initial page to list all the customer in database
	@RequestMapping("/list")
	public String list(Model themodel) {
		List<Customer> customer = customerService.findAllCustomer();
		themodel.addAttribute("Customers", customer);
		return "list-customer";
		
	}
	//open new addorupate form fill in the details and click save button to call save the detail. 
	@RequestMapping("/Addform")
	public String addForm(Model themodel) {
		Customer customer = new Customer();
		themodel.addAttribute("Customer", customer);
		return "addorupdateform";
			
		}
	//get id from the web and fetch the details from database  and then it will display in addorupate form then click save button to call save the detail. 
	@RequestMapping("/Updateform")
	public String updateForm(@RequestParam("CustomerId") int id,Model themodel) {
		Customer customer=customerService.findById(id);
		themodel.addAttribute("Customer", customer);
		return "addorupdateform";
	}
	
	// This method is called onclick of save button ,  when we update or add new details
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,Customer customer) {
		// when we are update the existing customer detail.
		if (id != 0) {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		} else
			// when we add new detail.
			customer = new Customer(firstName, lastName, email);
		customerService.save(customer);

		return "redirect:/list";
	}
	// get id from the web and fetch the details from database and then delete all entry and redirect to list page.
	@RequestMapping("/delete")
	public String delete(@RequestParam("CustomerId") int id) {
		customerService.deleteById(id);
		return "redirect:/list";
		
	}
	}


