package com.greatlearning.javafsd.customerrelationshipmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.javafsd.customerrelationshipmanagement.entity.Customer;
import com.greatlearning.javafsd.customerrelationshipmanagement.service.CustomerService;


//this is the controller method which accepts the request from the client and sends the response
@Controller
@RequestMapping ("/customers")
public class CustomersController {

	@Autowired
	private CustomerService customerService;
	
	
	// this method is used to display the list of all customers saved in the database
	@RequestMapping ("/list")
	public String handleListCustomers (Model theModel) {
		
		List <Customer > customers = customerService.listAll();
		
		theModel.addAttribute("customers", customers);
		
		return "customers-listing";
	}
}
