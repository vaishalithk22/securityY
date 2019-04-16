package com.securex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.securex.api.model.admin.AdminDto;
import com.securex.api.model.admin.Administrator;
import com.securex.api.model.customer.Customer;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.dispatcher.Dispatcher;
import com.securex.api.model.dispatcher.DispatcherDto;
import com.securex.api.model.guard.Guard;
import com.securex.api.model.guard.GuardDto;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.AdminService;
import com.securex.api.service.CustomerService;
import com.securex.api.service.DispatcherService;
import com.securex.api.service.GuardService;
import com.securex.api.service.UserService;
import com.securex.api.service.impl.SendMailService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private GuardService guardService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DispatcherService dispatcherService;
    


    @RequestMapping(value="/customer/signup", method = RequestMethod.POST)
    public Customer saveUser(@RequestBody CustomerDto customerdata){
    	UserCredentials user= userService.saveCredentials(customerdata);
    	
        return customerService.saveCustomer(customerdata,user);
    }
    
    
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/admin/addguard", method = RequestMethod.POST)
    public Guard saveUser(@RequestBody GuardDto guarddata){
    	UserCredentials user= userService.saveCredentials(guarddata);
        Guard newguard= guardService.saveGuard(guarddata,user);
        SendMailService mail= new SendMailService();
        mail.sendMail(newguard.getUser().getUsername(), newguard.getActivationCode());
        return newguard;
    }
    
   @PreAuthorize("hasRole('ADMIN')") 
    @RequestMapping(value="/admin/adddispatcher", method = RequestMethod.POST)
    public Dispatcher saveUser(@RequestBody DispatcherDto dispatcherdata){
    	UserCredentials user= userService.saveCredentials(dispatcherdata);
    	
        return dispatcherService.saveDipatcher(dispatcherdata,user);
    }
    //@PreAuthorize("hasRole('SUPERADMIN')")
    @RequestMapping(value="/superadmin/addadmin", method = RequestMethod.POST)
    public Administrator saveUser(@RequestBody AdminDto admindata){
    	UserCredentials user= userService.saveCredentials(admindata);
    	
        return adminService.saveAdmin(admindata,user);
    }
    
   // @PreAuthorize("hasRole('GUARD')") 
    @RequestMapping(value="/guard/signup/{activationcode}", method = RequestMethod.GET)
    public Guard guardregister(@PathVariable(value="activationcode") String activationcode)
    {
    	return guardService.register(activationcode);
    	
    }
    
    
    
    
    
    
    
    
    
  //@Secured({"ROLE_ADMIN", "ROLE_USER"})
//  @PreAuthorize("hasRole('ADMIN')")
//  @RequestMapping(value="/users", method = RequestMethod.GET)
//  public List<UserCredentials> listUser(){
//      return userService.findAll();
//  }
//
//  //@Secured("ROLE_USER")
//  @PreAuthorize("hasRole('CUSTOMER')")
//  ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
//  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//  public UserCredentials getOne(@PathVariable(value = "id") Long id){
//      return userService.findById(id);
//  }
}
