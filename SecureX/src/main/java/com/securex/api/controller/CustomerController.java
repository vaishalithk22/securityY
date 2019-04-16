package com.securex.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.securex.api.model.Customer;
import com.securex.api.request.CustomerRequest;
import com.securex.api.response.ResponseObject;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.CustomerService;
import com.securex.api.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CustomerController {
	
	//private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value="/customer/signup", method = RequestMethod.POST)
    public ResponseObject saveUser(@RequestBody CustomerRequest customerdata){
    	UserCredentials user= userService.saveCredentials(customerdata);
    	
    	Customer customer= customerService.saveCustomer(customerdata,user);
    	ResponseObject ro= new ResponseObject();
    	ro.setCode(101);
    	ro.setData((Customer)customer);
    	ro.setMessage("Customer Registration Successful.");
    	return ro;
    }
}

