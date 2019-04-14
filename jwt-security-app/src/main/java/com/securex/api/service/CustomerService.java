package com.securex.api.service;

import com.securex.api.model.customer.Customer;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.user.UserCredentials;

public interface CustomerService 
{
		Customer saveCustomer(CustomerDto customer,UserCredentials user);
	/*
	 * List<Customer> findAll(); void delete(long id); Customer findOne(String
	 * customername);
	 * 
	 * Customer findById(Long id);
	 */
	
}
