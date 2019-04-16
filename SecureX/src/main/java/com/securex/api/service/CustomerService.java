package com.securex.api.service;

import com.securex.api.model.Customer;
import com.securex.api.request.CustomerRequest;
import com.securex.api.security.UserCredentials;

public interface CustomerService 
{
		Customer saveCustomer(CustomerRequest customer,UserCredentials user);
	/*
	 * List<Customer> findAll(); void delete(long id); Customer findOne(String
	 * customername);
	 * 
	 * Customer findById(Long id);
	 */
	
}
