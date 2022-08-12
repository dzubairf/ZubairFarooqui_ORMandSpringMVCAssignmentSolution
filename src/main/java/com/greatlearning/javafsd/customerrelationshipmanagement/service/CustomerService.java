package com.greatlearning.javafsd.customerrelationshipmanagement.service;

import java.util.List;
import com.greatlearning.javafsd.customerrelationshipmanagement.entity.Customer;


// This is an interface which lists all the methods that we will use for the service
public interface CustomerService {
List <Customer> listAll ();
	
	Customer findById (int  theId);
	
	void save (Customer theStudent);
	
	void deleteById (int theId);
}
