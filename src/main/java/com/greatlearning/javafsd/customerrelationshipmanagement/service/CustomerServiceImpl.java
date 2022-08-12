package com.greatlearning.javafsd.customerrelationshipmanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.javafsd.customerrelationshipmanagement.entity.Customer;
import com.greatlearning.javafsd.customerrelationshipmanagement.service.CustomerService;

//this class implements the methods/services in CustomerService interface
@Repository
public class CustomerServiceImpl implements CustomerService {

	private Session session;
	
	
	// this creates a session or opens an existing session  
	@Autowired
	CustomerServiceImpl (SessionFactory sessionFactory){
		try {
			session = sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	
	// this method lists all the details of customers from the table
	@Transactional
	public List<Customer> listAll(){
		Transaction transaction = session.beginTransaction();
		
		List <Customer> customers
			= session.createQuery ("from customer_entity").list();
		
		transaction.commit();
		return customers;
	}
	
	
	// this method finds a customer from the database table based on his id
	@Transactional 
	public Customer findById (int id) {
		Customer customer = new Customer();
		
		Transaction transaction = session.beginTransaction();
		customer =session.get(Customer.class, id);
		transaction.commit();
		
		return customer;
	}
	
	// this method is used to save/update any specific customer's details in the database table
	
	@Transactional
	public void save(Customer customer) {
		
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(customer);
		transaction.commit();
	}
	
	// this method deletes entry of a customer based on id given as input
	
	@Transactional 
	public void deleteById (int id) {
		Transaction transaction = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		transaction.commit();
	}
}
