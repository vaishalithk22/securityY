package com.securex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.securex.api.model.Dispatcher;
import com.securex.api.model.Guard;
import com.securex.api.request.DispatcherRequest;
import com.securex.api.request.GuardRequest;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.AdminService;
import com.securex.api.service.DispatcherService;
import com.securex.api.service.GuardService;
import com.securex.api.service.UserService;
//import com.securex.api.service.impl.SendMailService;
public class AdminController {
	@Autowired
    private UserService userService;

    @Autowired
    private GuardService guardService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DispatcherService dispatcherService;
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/admin/addguard", method = RequestMethod.POST)
    public Guard saveUser(@RequestBody GuardRequest guarddata){
    	UserCredentials user= userService.saveCredentials(guarddata);
        Guard newguard= guardService.saveGuard(guarddata,user);
//        SendMailService mail= new SendMailService();
//        mail.sendMail(newguard.getUser().getUsername(), newguard.getActivationCode());
        return newguard;
    }
    
   @PreAuthorize("hasRole('ADMIN')") 
    @RequestMapping(value="/admin/adddispatcher", method = RequestMethod.POST)
    public Dispatcher saveUser(@RequestBody DispatcherRequest dispatcherdata){
    	UserCredentials user= userService.saveCredentials(dispatcherdata);
    	
        return dispatcherService.saveDipatcher(dispatcherdata,user);
    }
}
