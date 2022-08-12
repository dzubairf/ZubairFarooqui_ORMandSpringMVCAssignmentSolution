package com.greatlearning.javafsd.customerrelationshipmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.javafsd.customerrelationshipmanagement.entity.Customer;
import com.greatlearning.javafsd.customerrelationshipmanagement.service.CustomerService;


//this is the controller method which accepts the request from the client and sends the response
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	// this method creates a customer object by fetching existing data from database
		// used for updating information regarding customer
		@RequestMapping ("/showFormForUpdate")
		public String handleBeginUpdate (
				@RequestParam("customerId") int theId, 
				Model theModel) {
			
			Customer customer = customerService.findById(theId);
			theModel.addAttribute("customer", customer);
			
			return "customer-details";
			
		}

		// this method creates a new customer object
		// used for adding new customer to the database
		@RequestMapping ("/showFormForAdd")
		public String handleBeginAdd (Model theModel) {
			
			Customer customer = new Customer();
			theModel.addAttribute("customer", customer);
			
			return "customer-details";
			
		}
		
		// this method adds/updates customer info in the database
		@PostMapping("/save")
		public String handleSave(
				@RequestParam("id") int theId,
				@RequestParam("firstName") String firstName,
				@RequestParam("lastName") String lastName,
				@RequestParam("email") String email
				 ) {
			Customer customer;
			
			if (theId!=0) {
				
				// Update customer (this is update scenario)
				customer = customerService.findById(theId);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setEmail(email);
			} else // this is add customer scenario
				customer = new Customer (firstName,lastName,email);
				customerService.save(customer);
				return "redirect:/customers/list";
		}
		
		// this method is used to delete the info regarding selected customer
		
		@RequestMapping ("/delete")
		public String handleDelete(
				@RequestParam("customerId") int theId) {
			
			customerService.deleteById(theId);
			return "redirect:/customers/list";
		}
}
