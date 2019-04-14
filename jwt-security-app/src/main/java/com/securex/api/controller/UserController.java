package com.securex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.securex.api.model.customer.Customer;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.CustomerService;
import com.securex.api.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<UserCredentials> listUser(){
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('CUSTOMER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserCredentials getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public Customer saveUser(@RequestBody CustomerDto customerdata){
    	UserCredentials user= userService.saveCredentials(customerdata);
    	
        return customerService.saveCustomer(customerdata,user);
    }

    

}
