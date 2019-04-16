package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.CustomerDao;
import com.securex.api.model.Customer;
import com.securex.api.request.CustomerRequest;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerDao customerdao;
	@Override
	public Customer saveCustomer(CustomerRequest customerdata , UserCredentials user) {
		// TODO Auto-generated method stub
		
		Customer customer= new Customer();
		customer.setFirstname(customerdata.getFirstname());
		customer.setLastname(customerdata.getLastname());
		customer.setStreet1(customerdata.getStreet1());
		customer.setStreet2(customerdata.getStreet2());
		customer.setCity(customerdata.getCity());
		customer.setState(customerdata.getState());
		customer.setZipcode(customerdata.getZipcode());
		customer.setPhone(customerdata.getPhone());
		customer.setPhotourl(customerdata.getPhotourl());
		customer.setUser(user);
		
		return customerdao.save(customer);
	}
}
